package hostpet.enums;

public enum Perfil {
	
		ADMIN(0), ADMIN_ONG(1), USUARIO_ONG(2), USUARIO(3);
		private final int value;

    private Perfil(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    
}
