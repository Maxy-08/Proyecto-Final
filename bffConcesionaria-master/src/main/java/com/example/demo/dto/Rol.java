package com.example.demo.dto;

public enum Rol{
	
	ADMIN("Admin"),
    EMPLEADO("Empleado");
	
    private String displayName;

    Rol(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
   
}
