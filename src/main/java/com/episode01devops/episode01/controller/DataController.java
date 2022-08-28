@RestController
public class DataController {

        @GetMapping("/")
        public String healthCheck() {
                return "HEALTH CHECK OK!";
        }

        @GetMapping("/version")
        public String version() {
                return "The actual version is 1.0.0";
        }

        @GetMapping("/nations")
        public JsonNode getRandomNations() {
                var objectMapper = new ObjectMapper();
                var faker = new Faker(new Locale("en-US"));
                var nations = objectMapper.createArrayNode();
                for (var i = 0; i < 10; i++) {
                        var nation = faker.nation();
                        nations.add(objectMapper.createObjectNode()
                                .put("nationality", nation.nationality())
                                .put("capitalCity", nation.capitalCity())
                                .put("flag", nation.flag())
                                .put("language", nation.language()));
                }
                return nations;
        }

        @GetMapping("/currencies")
        public JsonNode getRandomCurrencies() {
                var objectMapper = new ObjectMapper();
                var faker = new Faker(new Locale("en-US"));
                var currencies = objectMapper.createArrayNode();
                for (var i = 0; i < 20; i++) {
                        var currency = faker.currency();
                        currencies.add(objectMapper.createObjectNode()
                                .put("name", currency.name())
                                .put("code", currency.code()));
                }
                return currencies;

        }

}