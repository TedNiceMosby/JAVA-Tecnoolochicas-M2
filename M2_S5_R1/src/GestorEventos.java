import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

public class GestorEventos {

    public static void monitorear() {
        Flux.combineLatest(
                        SistemaCritico.sensoresTrafico(),
                        SistemaCritico.estadoClima(),
                        SistemaCritico.accidentes(),
                        SistemaCritico.trenes(),
                        SistemaCritico.semaforos(),
                        (t, c, a, tr, s) -> Tuples.of(t, c, a, tr, s)
                )
                .flatMap(tuple -> {
                    int criticos = 0;
                    StringBuilder sb = new StringBuilder();

                    if (tuple.getT1() != null) { sb.append(tuple.getT1()).append("\n"); criticos++; }
                    if (tuple.getT2() != null) { sb.append(tuple.getT2()).append("\n"); criticos++; }
                    if (tuple.getT3() != null) { sb.append(tuple.getT3()).append("\n"); criticos++; }
                    if (tuple.getT4() != null) { sb.append(tuple.getT4()).append("\n"); criticos++; }
                    if (tuple.getT5() != null) { sb.append(tuple.getT5()).append("\n"); criticos++; }

                    if (criticos >= 3) {
                        sb.append("🚨 Alerta global: múltiples eventos críticos detectados\n");
                    }

                    return Flux.just(sb.toString());
                })
                .subscribe(System.out::println);
    }
}
