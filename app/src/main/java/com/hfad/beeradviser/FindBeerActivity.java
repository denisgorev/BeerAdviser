package com.hfad.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {
    private BeerExpert expert = new BeerExpert(); //переменная типа BeerExpert()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer (View view) {

        TextView brands = (TextView)findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem()); //получение значения из списка
        List<String> brandsList = expert.getBrands(beerType); //передается выбранное значение из списка в метод объекта класса BeerExpert
        StringBuffer brandsFormatted = new StringBuffer();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }
//Вывести сорта пива
        brands.setText(brandsFormatted);
    }
}
