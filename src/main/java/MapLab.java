import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapLab {
    public static void main(String[] args) {
        String[] balls = {"1", "2", "3", "4", "5", "6"};

        Observable.fromArray(balls)
                .map(it -> Integer.parseInt(it))
                .filter(input -> input % 2 == 0)
                .map(it -> it + "<>")
                .subscribe(it -> System.out.println(it));

        /**using function*/
        Function<String, String> mapFunc = input -> input + "<>";

        Observable.fromArray(balls)
                .map(mapFunc)
                .subscribe(it-> System.out.println(it));
    }
}
