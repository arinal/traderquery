package com.traderquery;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PockerRest service = new Retrofit.Builder()
                .baseUrl("https://fvjkpkflnc.execute-api.us-east-1.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(PockerRest.class);

        Observable<List<Trader>> traderTask = service.getTraders();
        Observable<List<Transaction>> transactionTask = service.getTransactions();

        Observable.combineLatest(traderTask, transactionTask, Pair::new)
                .forEach(pair -> solveProblems(pair.value1, pair.value2));
    }

    static void solveProblems(List<Trader> traders, List<Transaction> transactions) {
        System.out.println("find all singapaporean traders sorted by name");
        traders.stream().filter(t -> t.city.equals("Singapore")).forEach(System.out::println);

        System.out.println("\ntransaction with highest transaction value");
        Transaction highest = transactions.stream().sorted((t1, t2) -> t2.value.compareTo(t1.value)).findFirst().get();
        System.out.println(highest);

        System.out.println("\nall transactions in 2016 sorted descendingly by date");
        transactions.stream().filter(t -> t.getDate().getYear() + 1900 == 2016)
                .sorted((t1, t2) -> Long.valueOf(t2.timestamp).compareTo(t1.timestamp))
                .forEach(System.out::println);

        System.out.println("\naverage beijing traders' transaction");
        List<String> beijingIds = traders.stream()
                .filter(t -> t.city.equals("Beijing")).map(t -> t.id)
                .collect(Collectors.toList());
        List<Transaction> beijingTxs = transactions.stream()
                .filter(tx -> beijingIds.stream().anyMatch(id -> id.equals(tx.traderId)))
                .collect(Collectors.toList());
        long count = beijingTxs.size();
        BigDecimal total = beijingTxs.stream().map(t -> t.value).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal average = total.divide(BigDecimal.valueOf(count));
        System.out.println(average);
    }
}