package config;

public enum Status {
	
	REQUEST_ERROR("��ſ���"),	
	SYSTEM_ERROR("�ý��ۿ���"),
	SUCCESS("����");
	
	private String value;
	
	Status(String key){
		value = key;
    }
    
    // span �� ��ȯ
    public String getValue(){
        return value;
    }	
}
