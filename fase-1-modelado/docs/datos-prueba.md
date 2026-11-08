# Datos de prueba

## Facultades y carreras (árbol general)

La UTA tiene **10 facultades**. Las carreras son de referencia y pueden variar por periodo académico.
Los **niveles y paralelos son ilustrativos**: en cada facultad solo una carrera baja hasta niveles y paralelos.

| Código | Facultad | Carreras (código) |
|---|---|---|
| **FISEI** | Ingeniería en Sistemas, Electrónica e Industrial | SW (Software); TI (Tecnologías de la Información); TEL (Telecomunicaciones); AR (Automatización y Robótica); IND (Industrial) |
| **FCIAB** | Ciencia e Ingeniería en Alimentos y Biotecnología | ALI (Ingeniería en Alimentos); BIO (Ingeniería Bioquímica) |
| **FCA** | Ciencias Administrativas | OE (Organización de Empresas); MKT (Marketing y Gestión de Negocios) |
| **FCAGP** | Ciencias Agropecuarias | AGR (Ingeniería Agronómica); MVZ (Medicina Veterinaria y Zootecnia); AGP (Ingeniería Agropecuaria) |
| **FICM** | Ingeniería Civil y Mecánica | CIV (Ingeniería Civil); MEC (Ingeniería Mecánica) |
| **FCS** | Ciencias de la Salud | MED (Medicina); ENF (Enfermería); PSC (Psicología Clínica); TF (Terapia Física); LC (Laboratorio Clínico); ET (Estimulación Temprana) |
| **FDAA** | Diseño y Arquitectura | DGP (Diseño Gráfico Publicitario); AI (Arquitectura de Interiores); DM (Diseño de Modas) |
| **FCAUD** | Contabilidad y Auditoría | CA (Contabilidad y Auditoría); GF (Gestión Financiera); EE (Economía Empresarial) |
| **FCHE** | Ciencias Humanas y de la Educación | EB (Educación Básica); EI (Educación Inicial); ING (Inglés); CF (Cultura Física); IC (Informática y Computación); TH (Turismo y Hotelería); PE (Psicología Educativa); PI (Psicología Industrial); EAE (Educación Ambiental y Ecoturismo) |
| **FJCS** | Jurisprudencia y Ciencias Sociales | DER (Derecho); CS (Comunicación Social) |

Totales del árbol completo: **88 nodos**, **57 hojas**, **altura 4**, grado de la raíz **10**.

## ABB de ejemplo (paralelo SW-N3-B)

Orden de inserción: `50, 30, 70, 20, 40, 60, 80, 35, 65`

Lo carga `app/DatosPrueba.java`. Funciona apenas la Fase 2 implemente `agregar`, `buscar` e `insertar`.

## Caso degenerado (para discutir)

Insertar `10, 20, 30, 40, 50` produce un árbol que es una lista: buscar el 50 visita los 5 nodos.

```mermaid
flowchart TD
    n10(("10"))
    n20(("20"))
    n30(("30"))
    n40(("40"))
    n50(("50"))
    n40 -->|der| n50
    n30 -->|der| n40
    n20 -->|der| n30
    n10 -->|der| n20
```
