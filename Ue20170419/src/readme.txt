Schreiben Sie eine Klasse HttpSiteInfo mit zwei Attributen
  - private String domain
  - public ArrayList<String> pageResult
  
 Implementieren Sie eine öffentliche Methode public void run(),
 welche über ein Socket auf die übergebene Domain via einem "HTTP-GET"-Befehl zugreift
 und die komplette Seite das Attribut pageResult speichert.
 
 Stellen Sie sicher, dass diese Klasse später über einen Thread gestartet werden kann.
 
 ----------------
 
 Implementieren Sie eine Demo-Anwendung, in welcher Sie in der main-Methode eine manuelle Liste von Domains 
 verwalten. Beispiele finden Sie untenstehend.
 
 Erstellen Sie in einer Schleife Thread-Objekte von HttpSiteInfo und lassen Sie die die Seiten parallel herunterladen.
 
 Ergänzung:
 Schreiben Sie eine weitere Klasse ArchiveSite, welche im Konstruktor eine ArrayList<String>, welche eine komplette HTTP-Seite
 entspricht, und einen Pfad übernimmt. Schreiben Sie eine Methode public void write(), welche die ArrayList in die übergebene 
 Datei (Pfad) schreibt. Verwenden Sie diese Klasse in der Methode run von HttpSiteInfo

ArrayList<String> sites = new ArrayList<>();
sites.add("alibaba.com");
sites.add("amazonaws.com");
sites.add("ask.com");
sites.add("bbc.co.uk");
sites.add("bing.com");
sites.add("chinadaily.com.cn");
sites.add("cnn.com");
sites.add("craigslist.org");
sites.add("dailymail.co.uk");
sites.add("dailymotion.com");
sites.add("daum.net");
sites.add("ebay.co.uk");
sites.add("ebay.com");
sites.add("globo.com");
sites.add("gmw.cn");
sites.add("go.com");
sites.add("goal.com");
sites.add("goo.ne.jp");
sites.add("hao123.com");
sites.add("imagebam.com");
sites.add("imdb.com");
sites.add("live.com");
sites.add("microsoft.com");
sites.add("milliyet.com.tr");
sites.add("mirror.co.uk");
sites.add("msn.com");
sites.add("naver.com");
sites.add("naver.jp");
sites.add("office.com");
sites.add("olx.biz.id");
sites.add("onet.pl");
sites.add("pzy.be");
sites.add("qq.com");
sites.add("rakuten.co.jp");
sites.add("sina.com.cn");
sites.add("sohu.com");
sites.add("soso.com");
sites.add("telegraph.co.uk");
sites.add("tianya.cn");
sites.add("uol.com.br");
sites.add("weibo.com");
sites.add("wikia.com");
sites.add("wikihow.com");
sites.add("xinhuanet.com");
sites.add("xnxx.com");
sites.add("yahoo.co.jp");
 