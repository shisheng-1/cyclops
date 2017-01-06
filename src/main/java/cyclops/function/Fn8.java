package cyclops.function;

import java.util.Optional;
import java.util.concurrent.Executor;

import cyclops.control.Eval;
import cyclops.async.Future;
import cyclops.control.Maybe;
import cyclops.control.Try;

public interface Fn8<T1, T2, T3, T4, T5, T6, T7, T8, R> {

    public R apply(T1 a, T2 b, T3 c, T4 d, T5 e, T6 f, T7 g, T8 h);
    /**
     * Create a curried function with arity of 8
     * 
     * e.g. with Lombok val 
     * 
     * <pre>{@code
     *      val fn  = λ((Integer a)-> (Integer b)-> a+b+)
     * }</pre>
     * @param quadFunc
     * @return supplied function
     */
    public static <T1, T2, T3, T4, T5, T6,T7,T8,R> Fn8<T1,T2,T3, T4, T5,T6,T7,T8,R> λ(final Fn8<T1,T2,T3,T4,T5,T6,T7,T8, R> func8) {
        return func8;
    }
    public static <T1, T2, T3, T4, T5, T6,T7,T8,R> Fn8<? super T1,? super T2,? super T3, ? super T4, ? super T5,? super T6,? super T7,? super T8,? extends R> v(final Fn8<? super T1,? super T2,? super T3,? super T4,? super T5,? super T6,? super T7,? super T8, ? extends R> func8) {
        return func8;
    }
    default Fn1<T2, Fn1<T3, Fn1<T4, Fn1<T5, Fn1<T6, Fn1<T7, Fn1<T8, R>>>>>>> apply(final T1 s) {
        return Curry.curry8(this)
                    .apply(s);
    }

    default Fn1<T3, Fn1<T4, Fn1<T5, Fn1<T6, Fn1<T7, Fn1<T8, R>>>>>> apply(final T1 s, final T2 s2) {
        return Curry.curry8(this)
                    .apply(s)
                    .apply(s2);
    }

    default Fn1<T4, Fn1<T5, Fn1<T6, Fn1<T7, Fn1<T8, R>>>>> apply(final T1 s, final T2 s2, final T3 s3) {
        return Curry.curry8(this)
                    .apply(s)
                    .apply(s2)
                    .apply(s3);
    }

    default Fn1<T5, Fn1<T6, Fn1<T7, Fn1<T8, R>>>> apply(final T1 s, final T2 s2, final T3 s3, final T4 s4) {
        return Curry.curry8(this)
                    .apply(s)
                    .apply(s2)
                    .apply(s3)
                    .apply(s4);
    }

    default Fn1<T6, Fn1<T7, Fn1<T8, R>>> apply(final T1 s, final T2 s2, final T3 s3, final T4 s4, final T5 s5) {
        return Curry.curry8(this)
                    .apply(s)
                    .apply(s2)
                    .apply(s3)
                    .apply(s4)
                    .apply(s5);
    }

    default Fn1<T7, Fn1<T8, R>> apply(final T1 s, final T2 s2, final T3 s3, final T4 s4, final T5 s5, final T6 s6) {
        return Curry.curry8(this)
                    .apply(s)
                    .apply(s2)
                    .apply(s3)
                    .apply(s4)
                    .apply(s5)
                    .apply(s6);
    }

    default Fn1<T8, R> apply(final T1 s, final T2 s2, final T3 s3, final T4 s4, final T5 s5, final T6 s6, final T7 s7) {
        return Curry.curry8(this)
                    .apply(s)
                    .apply(s2)
                    .apply(s3)
                    .apply(s4)
                    .apply(s5)
                    .apply(s6)
                    .apply(s7);
    }
    default Fn8<T1, T2, T3, T4, T5, T6, T7, T8, Maybe<R>> lift() {
        return (s1, s2, s3, s4, s5,s6,s7,s8) -> Maybe.fromLazy(Eval.later(()->Maybe.ofNullable(apply(s1,s2,s3,s4,s5,s6,s7,s8))));
    }
    default Fn8<T1, T2, T3, T4, T5, T6, T7,T8,Future<R>> lift(Executor ex) {

        return (s1, s2, s3, s4, s5,s6,s7,s8) -> Future.ofSupplier(() -> apply(s1, s2, s3, s4, s5,s6,s7,s8), ex);
    }

    default Fn8<T1, T2, T3, T4, T5, T6, T7, T8,Try<R, Throwable>> liftTry() {
        return (s1, s2, s3, s4, s5,s6,s7,s8) -> Try.withCatch(() -> apply(s1, s2, s3, s4, s5,s6,s7,s8), Throwable.class);
    }

    default Fn8<T1, T2, T3, T4, T5, T6, T7, T8,Optional<R>> liftOpt() {

        return (s1, s2, s3, s4, s5, s6,s7,s8) -> Optional.ofNullable(apply(s1, s2, s3, s4, s5, s6,s7,s8));
    }

    default Fn1<? super T1, Fn1<? super T2, Fn1<? super T3, Fn1<? super T4, Fn1<? super T5,Fn1<? super T6,Fn1<? super T7,Fn1<? super T8, ? extends R>>>>>>>> curry() {
        return CurryVariance.curry8(this);
    }
}
