"# MetroRailTicketingSystem" 

- Assignment prepared for ThoughtWorks(Hyderabad): Extreme Programming For Developers session.
- This code supports fare calculation for Single Line only. Multiple line fare resolution requires some algorithms which I'm not aware of at the moment will update it as soon as I get to know.

"# Problem Statement :"

- Transportation in a metro city is a major issue for the Government of Telangana, and Hyderabad is not an exception to this rule. Keeping this in view, the Hyderabad Metro Rail (HMR) is being developed as one of the largest modern transport systems in the world based upon the PPP model. There are a lot of systems in HMR, one of them is Ticketing System. A passenger needs a ticket to travel by the metro rail. Build a system which can print the ticket, given both source and destination. 
- Following are the pricing rules to consider:
- Upto the 3 stations journey, fare is   10.00/- ( for all Lines ) ₹ After the 3 stations, for every extra station,  2.50/- for Line I₹ 2.00/- for Line II₹ 3.00/- for Line III₹ There is no extra cost associated with changing lines
- Expected Input format: Enter Source Station Code: A4 Enter Destination Station Code: B12
- Expected Output format: ************************************************************* Hyderabad Metro Rail Source: Kukatpally Distance ( stations): 18 Destination: Charminar Cost: 46.50/₹ *************************************************************

- Following are the details of the Lines / Stations: 

3 Lines - 66 Stations - 3 Interchange Stations: 
Line I - Miyapur to L B Nagar - 27 Stations, 29 KM Line II- JBS to Falaknuma - 16 Stations, 15 KM Line III - Nagole to Shilparamam - 23 Stations, 28 KM

Stations – Line I: 
Code Station Code Station Code Station A1 Miyapur A2 JNTU College A3 KPHB Colony A4 Kukatpally A5 Balanagar A6 Moosapet A7 Bharat Nagar A8 Erragadda A9 ESI Hospital A10 S R Nagar X1 Ameerpet A12 Punjagutta A13 Irrum Manzil A14 Khairatabad A15 Lakdikapul A16 Assembly A17 Nampally A18 Gandhi Bhavan A19 Osmania Medical College X2 MG Bus station A21 Malakpet A22 New Market A23 Musarambagh A24 Dilsukhnagar A25 Chaitanyapuri A26 Victoria Memorial A27 L B Nagar 

Stations – Line II:
Code Station Code Station Code Station B1 JBS X3 Parade Grounds B3 Secunderabad B4 Gandhi Hospital B5 Musheerabad B6 RTC Cross Roads B7 Chikkadpally B8 Narayanguda B9 Sultan Bazar X2 M G Bus Station B11 Salarjung Museum B12 Charminar B13 Shalibanda B14 Shamsher Gunj B15 Jungametta B16 Falaknuma  

Stations - Line III: 
Code Station Code Station Code Station C1 Nagole C2 Uppal C3 Survey of India C4 NGRI C5 Habsiguda C6 Tarnaka C7 Mettuguda C8 Secunderabad X3 Parade Grounds C10 Paradise C11 Rasool Pura C12 Prakash Nagar C13 Begumpet X1 Ameerpet C15 Madhura Nagar C16 Yusuf Guda C17 Road No 5 Jubilee Hills C18 Jubilee Hills Check Post C19 Pedamma Temple C20 Madhapur C21 Durgam Chervu C22 HITEC City C23 Shilparamam 

Interchange Stations:
Code Station Connecting Lines X1 Ameerpet Station Line I & III X2 M G B S Station Line I & II X3 Parade Grounds Station Line II & III