package ua.mind.warehouse.domain;

/**
 * Created by Сергій on 17.01.14.
 */
public enum Role {
    STOREKEEPER (1L),
    WORKER (2L),
    ACCOUNTANT (3L),
    DIRECTOR (4L),
    ADMINISTRATOR (5L);

    private Long id;

    Role(Long id){
        this.id = id;
    }
    private Long getId(){
        return id;
    }

    public static Role getById(Long roleId) {
        for(Role e : values()) {
            if(e.id.equals(roleId)) return e;
        }
        return null;
    }
}
