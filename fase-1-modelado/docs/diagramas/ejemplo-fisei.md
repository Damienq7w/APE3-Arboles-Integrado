# Ejemplo resuelto: FISEI

Así debe quedar el trabajo de cada equipo (con su propia facultad y sus propias matrículas).

## Árbol general
```mermaid
flowchart TD
    FISEI["FISEI<br/><small>FACULTAD</small>"]

    SW["SW<br/><small>Software</small>"]
    TI["TI<br/><small>Tecnologías de la Información</small>"]
    TEL["TEL<br/><small>Telecomunicaciones</small>"]

    FISEI --> SW
    FISEI --> TI
    FISEI --> TEL

    %% ---------- SW ----------
    SW_N3["SW-N3<br/><small>NIVEL</small>"]
    SW_N3_A["SW-N3-A<br/><small>PARALELO</small>"]
    SW_N3_B["SW-N3-B<br/><small>PARALELO</small>"]
    SW_N4["SW-N4<br/><small>NIVEL</small>"]
    SW_N4_A["SW-N4-A<br/><small>PARALELO</small>"]
    SW_N4_B["SW-N4-B<br/><small>PARALELO</small>"]
    SW --> SW_N3
    SW_N3 --> SW_N3_A
    SW_N3 --> SW_N3_B
    SW --> SW_N4
    SW_N4 --> SW_N4_A
    SW_N4 --> SW_N4_B

    %% ---------- TI ----------
    TI_N3["TI-N3<br/><small>NIVEL</small>"]
    TI_N3_A["TI-N3-A<br/><small>PARALELO</small>"]
    TI_N3_B["TI-N3-B<br/><small>PARALELO</small>"]
    TI_N4["TI-N4<br/><small>NIVEL</small>"]
    TI_N4_A["TI-N4-A<br/><small>PARALELO</small>"]
    TI_N4_B["TI-N4-B<br/><small>PARALELO</small>"]
    TI --> TI_N3
    TI_N3 --> TI_N3_A
    TI_N3 --> TI_N3_B
    TI --> TI_N4
    TI_N4 --> TI_N4_A
    TI_N4 --> TI_N4_B

    %% ---------- TEL ----------
    TEL_N3["TEL-N3<br/><small>NIVEL</small>"]
    TEL_N3_A["TEL-N3-A<br/><small>PARALELO</small>"]
    TEL_N3_B["TEL-N3-B<br/><small>PARALELO</small>"]
    TEL_N4["TEL-N4<br/><small>NIVEL</small>"]
    TEL_N4_A["TEL-N4-A<br/><small>PARALELO</small>"]
    TEL_N4_B["TEL-N4-B<br/><small>PARALELO</small>"]
    TEL --> TEL_N3
    TEL_N3 --> TEL_N3_A
    TEL_N3 --> TEL_N3_B
    TEL --> TEL_N4
    TEL_N4 --> TEL_N4_A
    TEL_N4 --> TEL_N4_B
```



| Concepto | Respuesta |
|---|---|
| Raíz del subárbol | FISEI |
| Hojas | TI, TEL, AR, IND, SW-N3-A, SW-N3-B, SW-N4 |
| Altura del subárbol | 3 (en el árbol completo de la UTA, FISEI está en nivel 1 y la altura total es 4) |
| Grado de SW | 2 |
| Nivel de SW-N3-B (dentro del subárbol) | 3 |

## ABB del paralelo SW-N3-B

Orden: `50, 30, 70, 20, 40, 60, 80, 35, 65`

```mermaid
flowchart TD
    n50(("50"))
    n30(("30"))
    n20(("20"))
    n30 -->|izq| n20
    n40(("40"))
    n35(("35"))
    n40 -->|izq| n35
    n30 -->|der| n40
    n50 -->|izq| n30
    n70(("70"))
    n60(("60"))
    n65(("65"))
    n60 -->|der| n65
    n70 -->|izq| n60
    n80(("80"))
    n70 -->|der| n80
    n50 -->|der| n70
```

![ABB del paralelo SW-N3-B](ejemplo-fisei-abb.jpg)

| Concepto | Respuesta |
|---|---|
| Raíz | 50 |
| Hojas | 20, 35, 65, 80 |
| Altura | 3 |
| Nivel del 35 | 3 |
