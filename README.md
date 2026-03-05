#**Est**<br>
Veebirakendus laudade broneerimise jaoks.<br>

##**Eeltingimused:**<br>
    1. Arvutisse peab olema installitud Node.js (LTS versioon).<br>
    2. Arvutisse peab olema installitud Java JDK 17 (või uuem).<br>
    3. Soovitatav IDE: IntelliJ IDEA või VS Code (koos "Extension Pack for Java" lisaga).<br>

##**Käivitusjuhend:**<br>
    ###**Backendi käivitamine (Spring Boot):**<br>
    1. Ava projekt oma IDE-s.<br>
    2. Oota, kuni IDE laeb Maveni sõltuvused.<br>
    3. Käivita fail: backend_tableReservation/.../BackendTableReservationApplication.java.<br>
       Alternatiiv: Kui sul on paigaldatud Maven, võid terminalis bäkendi kaustas sisestada "./mvnw spring-boot:run." <br>   
    ###**Frontendi käivitamine (Vue.js):**<br>
    1. Ava uus terminaliaken ja liigu frontend kausta: "cd .\frontend_tableReservation\."<br>
    2. Siseta käsk "npm install" (see laeb alla vajalikud raamistikud, sh Vue).<br>
    3. Sisesta käsk "npm run dev".<br>
    4. Ava brauseris aadress, mille terminal sulle annab (nt http://localhost:5173/).<br>
