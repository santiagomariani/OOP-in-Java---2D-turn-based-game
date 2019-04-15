package Modelo.Edificio;

import Modelo.Juego.*;
import Modelo.Unidad.*;
import Modelo.Excepciones.*;

public interface EdificioAtacable {
    void recibirDanio(Arquero arquero);
    void recibirDanio(Espadachin espadachin);
    void recibirDanio(ArmaDeAsedio armaDeAsedio);
    void recibirDanio(Castillo castillo);
}
