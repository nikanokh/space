package org.example;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class Scene {
    private App app;
    private Node rootNode;
    private Spaceship spaceship;

    public Scene(App app) {
        this.app = app;
        this.rootNode = app.getRootNode();
    }

    public void init() {
        // Инициализация сцены (корабли, планеты и т.д.)
        Box box = new Box(1, 1, 3); // Размеры коробки
        Geometry shipGeom = new Geometry("Spaceship", box);
        Material shipMat = new Material(app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        shipMat.setColor("Color", ColorRGBA.Blue);
        shipGeom.setMaterial(shipMat);
        rootNode.attachChild(shipGeom);

        spaceship = new Spaceship(shipGeom);
    }

//    private void createTerrain() {
//        // Загрузка высотной карты
//        HeightMap heightMap = new ImageHeightMap(app.getAssetManager().loadTexture("Textures/heightmap.png").getImage());
//        terrain = new TerrainQuad("Terrain", 65, 513, heightMap.getHeightMap());
//
//        // Настройка материала для ландшафта
//        Material terrainMaterial = new Material(app.getAssetManager(), "Common/MatDefs/Terrain/Terrain.j3md");
//        terrainMaterial.setTexture("Alpha", app.getAssetManager().loadTexture("Textures/terrain_alpha.png"));
//        terrainMaterial.setTexture("Tex1", app.getAssetManager().loadTexture("Textures/grass.jpg"));
//        terrainMaterial.setTexture("Tex2", app.getAssetManager().loadTexture("Textures/rock.jpg"));
//        terrainMaterial.setTexture("Tex3", app.getAssetManager().loadTexture("Textures/sand.jpg"));
//
//        terrain.setMaterial(terrainMaterial);
//        terrain.setLocalTranslation(-terrain.getTerrainSize() / 2, 0, -terrain.getTerrainSize() / 2);
//        rootNode.attachChild(terrain);
//    }

    public void update(float tpf) {
        // Логика обновления сцены
        spaceship.update(tpf);
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }
}
