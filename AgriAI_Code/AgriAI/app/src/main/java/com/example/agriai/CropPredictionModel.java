package com.example.agriai;

import android.content.Context;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CropPredictionModel {

    private static final int NUM_CLASSES = 15; // Number of crop classes
    private static final int NUM_FEATURES = 7; // Number of input features (temperature, humidity, rainfall, soilType, month, district)

    private Interpreter tflite;

    public CropPredictionModel(Context context) throws IOException {
        MappedByteBuffer tfliteModel = loadModelFile(context);
        tflite = new Interpreter(tfliteModel);
    }

    private MappedByteBuffer loadModelFile(Context context) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("crop_prediction_model.joblib");
        FileChannel fileChannel = fileInputStream.getChannel();
        long startOffset = 0;
        long declaredLength = fileChannel.size();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public String predict(String district, String taluka, String weather, String soil, int month) {
        ByteBuffer inputBuffer = ByteBuffer.allocateDirect(NUM_FEATURES * 4); // 4 bytes per float
        inputBuffer.order(ByteOrder.nativeOrder());
        inputBuffer.toString();
        inputBuffer.toString();
        inputBuffer.toString();
        inputBuffer.toString(); // Convert soilType to hash code
        inputBuffer.putInt(month);

        ByteBuffer outputBuffer = ByteBuffer.allocateDirect(NUM_CLASSES * 4); // 4 bytes per float
        outputBuffer.order(ByteOrder.nativeOrder());

        tflite.run(inputBuffer, outputBuffer);

        outputBuffer.rewind();
        float[] predictions = new float[NUM_CLASSES];
        outputBuffer.asFloatBuffer().get(predictions);

        int maxIndex = 0;
        float maxProb = predictions[0];
        for (int i = 1; i < NUM_CLASSES; i++) {
            if (predictions[i] > maxProb) {
                maxProb = predictions[i];
                maxIndex = i;
            }
        }

        // Replace this with your crop names
        String[] cropNames = {"Bitter Gourd", "Bottle Gourd", "Brinjal/Eggplant","Cabbage","Carrot","Cauliflower","Cluster Beans","Coriander","Cucumber","Dill","Fenugreek","Garlic","Ginger","Green Chili","Okra","Onion","Peas","Potato","Radish","Ridge Gourd","Spinach","Spring Onion","Tomato","White Pumpkin"/* Add more crop names */};
        return cropNames[maxIndex];
    }

    public void close() {
        tflite.close();
    }
}

