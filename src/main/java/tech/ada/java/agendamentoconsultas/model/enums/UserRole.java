package tech.ada.java.agendamentoconsultas.model.enums;

public enum UserRole {
    PATIENT("patient"), DOCTOR("doctor");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
