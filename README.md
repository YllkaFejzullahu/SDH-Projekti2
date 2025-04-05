Ky projekt përmban dy algoritme kriptimi:

Gronsfeld Cipher – një version i modifikuar i Caesar Cipher që përdor një çelës numerik.

Irregular Columnar Transposition – një teknikë e transpozimit të shkronjave sipas një çelësi jo të rregullt.

Qëllimi i këtij projekti është të demonstrojë si funksionojnë këto algoritme në praktikë, si pjesë e sigurisë themelore të të dhënave.


Udhëzimet e Ekzekutimi të Programit:
1. Klonojmë repository nga GitHub
 git clone https://github.com/YllkaFejzullahu/SDH-Projekti2.git

2. Kalojmë në Folderin e Projektit
 cd SDH-Projekti2

3. Pasi kemi perdorur Java, ekzekutojmë këto komanda për ta kompiluar dhe ekzekutuar programin::
javac Main.java
java Main

4. Verifikimi i Ekzekutimit
Pasi të ekzekutohet, mund të shohim rezultatin në terminal ose në dritaren e komandave, për të verifikuar që programi ka punuar si duhet.

5. Për të dërguar Ndryshime në GitHub
Pasi të bëjmë ndonjë ndryshim në kodin tonë dhe dëshirojmë t’i dërgojmë në GitHub, mund të përdorim këto komanda:
git add .
git commit -m "Mesazhi i commit-it tonë"
git push origin main

Algoritmet e Implementuara:
1. Gronsfeld Cipher
Gronsfeld Cipher është një teknikë e thjeshtë kriptimi ku çdo shkronjë zhvendoset në alfabet sipas një çelësi numerik (p.sh. 314). Çelësi aplikohet për secilën shkronjë të mesazhit, duke u përsëritur nëse është më i shkurtër se mesazhi.

Shembull i Ekzekutimit:
Input: MESAZH
Çelësi: 314
Output: PHVBCL

2. Irregular Columnar Transposition
Ky algoritëm e shkruan mesazhin në një tabelë me kolona në bazë të një çelësi (p.sh. 4312). Pastaj kolonat lexohen në një rend të veçantë sipas rendit të çelësit, duke prodhuar një mesazh të koduar.

Shembull i Ekzekutimit:
Input: FSHEHTASIAESHTEART
Çelësi: 4312
Output: HETRSFEAEHSTASTI








