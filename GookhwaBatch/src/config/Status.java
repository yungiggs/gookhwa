package config;

public enum Status {
	
	REQUEST_ERROR("통신오류"),	
	SYSTEM_ERROR("시스템오류"),
	SUCCESS("성공");
	
	private String value;
	
	Status(String key){
		value = key;
    }
    
    // span 값 반환
    public String getValue(){
        return value;
    }	
}
