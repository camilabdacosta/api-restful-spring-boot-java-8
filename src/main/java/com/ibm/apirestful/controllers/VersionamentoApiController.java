import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class VersionamentoApiController {

	@GetMapping(value = "/v1/ola/{nome}")
	public ResponseEntity<String> olaNomeV1(@PathVariable("nome")String nome) {
		return ResponseEntity.ok(String.format("API v1: OLá %s", nome));
		
	}
	

	@GetMapping(value = "/v2/ola/{nome}")
	public ResponseEntity<String> olaNomeV2(@PathVariable("nome")String nome) {
		return ResponseEntity.ok(String.format("API v2: OLá %s", nome));
		
	}

	@GetMapping(value = "/v1/{nome}", headers = "X-API-Version=v1")
	public ResponseEntity<String> olaNomeHeaderV1(@PathVariable("nome")String nome) {
		return ResponseEntity.ok(String.format("API v1: OLá %s", nome));
		
	}
	@GetMapping(value = "/v1/{nome}", headers = "X-API-Version=v2")
	public ResponseEntity<String> olaNomeV2(@PathVariable("nome")String nome) {
		return ResponseEntity.ok(String.format("API v2: OLá %s", nome));
		
	}

}
