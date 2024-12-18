package org.example;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.material.Material;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class App extends SimpleApplication {

    private Scene gameScene;
    private BitmapText infoText;

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        // Инициализация сцены
        gameScene = new Scene(this);
        gameScene.init();

        // Настройка камеры
        cam.setLocation(new Vector3f(0, 1, 0)); // Позиция камеры внутри корабля
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y); // Направление камеры

        // Настройка текста для отображения информации
        initInfoText();
    }

    private void initInfoText() {
        BitmapFont font = assetManager.loadFont("Interface/Fonts/Default.fnt");
        infoText = new BitmapText(font, false);
        infoText.setSize(1f); // Размер текста
        infoText.setColor(ColorRGBA.White); // Цвет текста
        infoText.setLocalTranslation(10, settings.getHeight() - 10, 0); // Позиция текста
        guiNode.attachChild(infoText);
    }

    @Override
    public void simpleUpdate(float tpf) {
        gameScene.update(tpf);
        updateInfoText();
    }

    private void updateInfoText() {
        // Обновление текста с информацией
        String info = "Speed: " + gameScene.getSpaceship().getSpeed() + " m/s";
        infoText.setText(info);
    }
}