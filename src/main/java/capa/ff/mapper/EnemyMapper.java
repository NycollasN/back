package capa.ff.mapper;




import capa.ff.DTO.EnemyMapDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EnemyMapper {

    public Map<String, Object> processarCoordenadas(double x, double y, double z, EnemyMapDTO config) {
        Map<String, Object> resultado = new HashMap<>();

        // Exemplo de cálculo de distância relativa ao centro (0,0)
        double distancia = Math.sqrt(x * x + y * y);

        boolean dentroDoRaio = distancia <= config.getRaioMaximo();

        resultado.put("posX", x);
        resultado.put("posY", y);
        resultado.put("posZ", z);
        resultado.put("distancia", Math.round(distancia));
        resultado.put("visivelNoRadar", dentroDoRaio);
        resultado.put("cor", config.getCorInimigo());

        return resultado;
    }
}
