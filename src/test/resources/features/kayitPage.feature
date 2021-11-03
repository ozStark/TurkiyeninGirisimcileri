Feature: User can see 5 registration category options and click any category to highlight

  Background:
    Given User is at the kayit page

  Scenario: User should see 5 registration category options

    Then User should see five registration categories

      | Hedefim Küresel Başarı                   |
      | Kadın Teknoloji Girişimcisi              |
      | Çevre ve Sürdürülebilirlik Dostu Girişim |
      | Covid 19'u Fırsata Çeviren               |
      | 1512 ile Yola Çıkan Girişimci            |


  Scenario Outline:

    When User clicks any "<category>"
    Then The category is selected and SEÇ VE DEVAM ET button is visible

    Examples:
      | category                                 |
#      | Hedefim Küresel Başarı                   |
#      | Kadın Teknoloji Girişimcisi              |
      | Çevre ve Sürdürülebilirlik Dostu Girişim |
      | Covid 19'u Fırsata Çeviren               |
      | 1512 ile Yola Çıkan Girişimci            |