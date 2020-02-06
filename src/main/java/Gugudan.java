import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.functions.Function;

import java.util.function.BiFunction;

public class Gugudan {
    public static void main(String[] args) {
        int dan = 7;
        Observable.range(1,9)
                .flatMap(it -> Observable.just("" + it * dan))
                .subscribe(it -> System.out.println(it));

        /**나 혼자 한 거 */
        Observable.range(1,9)
                .flatMap(arg1 -> Observable
                        .range(1,9)
                        .flatMap(arg2 -> Observable.just(arg1 + " * " + arg2 + " = " + arg1 * arg2 ))
                ).subscribe(it -> System.out.println(it));

        /**
         * 책에 있는 거
         * */
        System.out.println("책 시작");
        Function<Integer, Observable<String>> function = num ->
                Observable.range(1, 9)
                        .map(it -> num + " * " + it + " = " + (it * num));

        Observable.range(1, 9)
                .flatMap(function)
                .subscribe(it -> System.out.println(it));

        Observable.just(7)
                .flatMap(num -> Observable.range(1, 9)
                        .map(input -> num * input)
                )
                .subscribe(it -> System.out.println(it));
    }
}
