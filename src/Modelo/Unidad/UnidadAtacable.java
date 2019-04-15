package Modelo.Unidad;

import Modelo.Edificio.*;
import Modelo.Juego.*;
import Modelo.Excepciones.*;

public interface UnidadAtacable {
    void recibirDanio(Arquero arquero);
    void recibirDanio(Espadachin espadachin);
    void recibirDanio(Castillo castillo);
}
