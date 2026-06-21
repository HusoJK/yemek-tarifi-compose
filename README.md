# Yemek Tarifi — Jetpack Compose Pratik Projesi

Jetpack Compose eğitiminde pekiştirme amacıyla geliştirilen mini bir uygulama.

## Açıklama

**Temel uygulama:** Eğitimde, sabit (hardcoded) verilerle tek bir yemeğin görseli, tarif bilgileri ve kendine ait özelliklerini gösteren basit bir yapı vardı.

**Benim eklentim:** 
- Bir `data class` oluşturarak 10 farklı yemekten oluşan bir liste hazırladım; her yemeğin kendi görseli, tarifi ve bilgileri var.
- UI'ı dinamik hale getirerek bu repository'den verileri index numarasına göre çektim (artık hardcoded değil).
- Görselin sağına ve soluna **ileri/geri** butonları ekleyerek yemekler arasında gezinmeyi sağladım.
- Listenin sonuna gelindiğinde (10. yemek) ileri butonuna basınca başa (0. index), başta iken geri butonuna basınca sona dönecek şekilde **döngüsel gezinme** mantığı kurdum.
- **Beğen** ve **Yorum yap** butonlarına basıldığında Toast mesajıyla kullanıcıya "üye ol" uyarısı gösterdim.

## Öğrendiklerim

- Scaffold yapısı ve TopAppBar kullanımı
- Column ve Row ile iç içe layout yönetimi, Vertical/Horizontal Arrangement ve Alignment
- remember ve mutableStateOf ile state yönetimi
- data class ile model oluşturma ve repository üzerinden dinamik veri çekme
- Index tabanlı döngüsel (circular) liste gezinme mantığı
- Toast mesajları ile kullanıcı bilgilendirme

## Kullanılan Teknolojiler

- Kotlin
- Jetpack Compose

## Ekran Görüntüleri

## Ekran Görüntüleri

<p align="center">
  <img src="https://github.com/user-attachments/assets/a2984fa3-d23f-413d-a8d5-38b33ba6b26d" width="180"/>
  <img src="https://github.com/user-attachments/assets/b2da95f4-4fac-4d22-9cee-db67e1a5c912" width="180"/>
  <img src="https://github.com/user-attachments/assets/e907a76d-05f1-49ef-b911-b54a80ed6043" width="180"/>
  <img src="https://github.com/user-attachments/assets/dc4ce5c8-7302-4a47-a36c-27ad336bb02b" width="180"/>
</p>

