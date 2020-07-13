Feature: Kullanıcı navigasyonu ve Kredi hesaplamarı
  @web
  Scenario Outline: Kredi hesaplamaları
      Given Anasayfaya gidilir
      And   Bireysel kredilere tıklanır
      And   Tüketici kredisi seçilir
      And   Hesaplama aracına gidilir
      When  Tüketici Mahmut kredisi hesaplanır <tuketiciTutar>,<tuketiciVade>
      Then  Tüketici kredisi kontrol edilir
      Then  Konut kredisine gidilir
      When  Konut kredisi hesaplanır  <konutTutar>,<konutVade>
      Then  Konut kredisi kontrol edilir
      Then  Tasit kredisine gidilir
      When  Taşıt kredisi hesaplanır <tasitTutar>,<tasitVade>
      Then  Taşıt kredisi kontrol edilir
    Examples:
      |tuketiciTutar |tuketiciVade    |konutTutar  |konutVade     |tasitTutar     |tasitVade  |
      |"100000"      |"24"            |"500000"    |"60"          |"250000"       |"24"       |
