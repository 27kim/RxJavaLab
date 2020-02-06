
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapLab {
    public static void main(String[] args) {
        Function<String, Observable<String>> func = input -> Observable.just(input + "<>" , input + "<>");
        String [] balls = {"a", "b", "c", "d", "e"};

        Observable.fromArray(balls)
                .flatMap(func)
                .subscribe(it -> System.out.println(it));

        Observable.fromArray(balls)
                .flatMap(it -> Observable.just(it + "<>" , it + "<>"))
                .subscribe(it -> System.out.println(it));



    }
}
