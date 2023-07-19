package com.deepak.backend.Services;

import com.deepak.backend.Beans.View;
import com.deepak.backend.Beans.ViewData;
import com.deepak.backend.DAO.ViewDAO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewService {


    public final ViewDAO dao = new ViewDAO();
    ViewDataService viewDataService = new ViewDataService();
    public List<ViewData> addViewData(View view) {

        if (!dao.addView(view)) {
            return null;
        }

        String country = view.getCountry();
        String indicator = view.getIndicator();
        String url = "http://api.worldbank.org/v2/country/"+country+"/indicator/"+indicator+"?format=json";
        JSONArray array = WorlBankDataDownloader.fetchData(url);
        JSONArray values = (JSONArray) array.get(1);
        List<ViewData> results = new ArrayList<>();
        for(Object value : values) {
            JSONObject value_object = (JSONObject) value;
            ViewData data = new ViewData();
            data.setView(view);
            data.setValue(Double.parseDouble(value_object.get("value").toString()));
            data.setDate(value_object.get("date").toString());
            results.add(data);
            System.out.println(viewDataService.addViewData(data));
        }
        return results;
    }

    public List<View> getAllViews() {
        List<View> resultSet = dao.getAllViews();
        return resultSet;
    }

    public List<View> getViewById(Long view_id) {
        List<View> resultSet = dao.getViewById(view_id);
        return resultSet;
    }


    public boolean deleteViewByID(Long view_id) {
        List<View> resultSet = dao.getViewById(view_id);
        return dao.deleteView(resultSet.get(0));

    }
    public List<ViewData> getViewDataBYID(Long view_id) {
        List<ViewData> resultSet = viewDataService.getCompleteViewData(getViewById(view_id).get(0));
        return resultSet;
    }

}

