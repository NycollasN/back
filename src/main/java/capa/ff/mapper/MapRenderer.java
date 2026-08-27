package capa.ff.mapper;




import capa.ff.DTO.EnemyMapDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapRenderer {

    public Map<String, Object> gerarPayloadRenderizacao(EnemyMapDTO config, int totalEntidades) {
        Map<String, Object> renderData = new HashMap<>();

        renderData.put("tamanhoRadar", config.getRaioMaximo() * 2);
        renderData.put("exibirHUD", config.isExibirDistancia());
        renderData.put("corPrincipal", config.getCorInimigo());
        renderData.put("entidadesMapeadas", totalEntidades);
        renderData.put("status", "READY");

        return renderData;
    }
}