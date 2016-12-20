package com.github.controlx.stations;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Abhishek Verma on 9/2/2016.
 *
 * -Forming Maps with the user defined station strings for different lines
 * -Replacing interchanging stations with our own code inorder to carry out transactions easily
 *
 */
public class Constants {
    protected static final String CONSTANT_LINE_1 = "A1 Miyapur, A2 JNTU College, A3 KPHB Colony, A4 Kukatpally, A5 Balanagar, A6 Moosapet, A7 Bharat Nagar, A8 Erragadda, A9 ESI Hospital, A10 S R Nagar, A11 Ameerpet, A12 Punjagutta, A13 Irrum Manzil, A14 Khairatabad, A15 Lakdikapul, A16 Assembly, A17 Nampally, A18 Gandhi Bhavan, A19 Osmania Medical College, A20 MG Bus station, A21 Malakpet, A22 New Market, A23 Musarambagh, A24 Dilsukhnagar, A25 Chaitanyapuri, A26 Victoria Memorial, A27 L B Nagar";
    protected static final String CONSTANT_LINE_2 = "B1 JBS, B2 Parade Grounds, B3 Secunderabad, B4 Gandhi Hospital, B5 Musheerabad, B6 RTC Cross Roads, B7 Chikkadpally, B8 Narayanguda, B9 Sultan Bazar, B10 M G Bus Station, B11 Salarjung Museum, B12 Charminar, B13 Shalibanda, B14 Shamsher Gunj, B15 Jungametta, B16 Falaknuma";
    protected static final String CONSTANT_LINE_3 = "C1 Nagole, C2 Uppal, C3 Survey of India, C4 NGRI, C5 Habsiguda, C6 Tarnaka, C7 Mettuguda, C8 Secunderabad, C9 Parade Grounds, C10 Paradise, C11 Rasool Pura, C12 Prakash Nagar, C13 Begumpet, C14 Ameerpet, C15 Madhura Nagar, C16 Yusuf Guda, C17 Road No 5 Jubilee Hills, C18 Jubilee Hills Check Post, C19 Pedamma Temple, C20 Madhapur, C21 Durgam Chervu, C22 HITEC City, C23 Shilparamam";

    public static final double LINE_1_FARE = 2.50;
    public static final double LINE_2_FARE = 2.00;
    public static final double LINE_3_FARE = 3.00;

    public static final LinkedHashMap<String, String> connectingStationMap = new LinkedHashMap<>();
    public static final LinkedHashMap<String, String> connectingStationMapReverseLookup = new LinkedHashMap<>();

    public static void bootStrapMaps(){
        connectingStationMap.put("A11","X1");
        connectingStationMap.put("A20","X2");
        connectingStationMap.put("B2","X3");
        connectingStationMap.put("B10","X2");
        connectingStationMap.put("C9","X3");
        connectingStationMap.put("C14","X1");


        connectingStationMapReverseLookup.put("X1A","A11");
        connectingStationMapReverseLookup.put("X2A","A20");
        connectingStationMapReverseLookup.put("X3B","B2");
        connectingStationMapReverseLookup.put("X2B","B10");
        connectingStationMapReverseLookup.put("X3C","C9");
        connectingStationMapReverseLookup.put("X1C","C14");
    }
}
