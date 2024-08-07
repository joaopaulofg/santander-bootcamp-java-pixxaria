package me.dio.dtos.pedido;

import lombok.Getter;
import lombok.Setter;
import me.dio.models.Pedido;
import me.dio.models.PedidoItem;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PedidoDTO {
    private Integer userId;
    private List<PedidoItemDTO> itens;

    public static PedidoDTO fromEntity(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setUserId(pedido.getUser().getId());
        List<PedidoItemDTO> itens = new ArrayList<>();

        for(PedidoItem pedidoItem : pedido.getItens()) {
            PedidoItemDTO pedidoItemDTO = new PedidoItemDTO();
            pedidoItemDTO.fromEntity(pedidoItem);
            itens.add(pedidoItemDTO);
        }
        pedidoDTO.setItens(itens);
        return pedidoDTO;
    }

}
