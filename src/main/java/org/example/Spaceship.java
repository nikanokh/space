package org.example;

import com.jme3.scene.Spatial;

public class Spaceship {
    private Spatial model;
    private float speed;

    public Spaceship(Spatial model) {
        this.model = model;
        this.speed = 0;
    }

    public Spatial getModel() {
        return model;
    }

    public float getSpeed() {
        return speed;
    }

    public void update(float tpf) {
        // Логика обновления корабля
        // Например, увеличение скорости
        speed += 1 * tpf; // Увеличиваем скорость
        model.move(0, 0, -speed * tpf); // Движение вперед
    }
}
