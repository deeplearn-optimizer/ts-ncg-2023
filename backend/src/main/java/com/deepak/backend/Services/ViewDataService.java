package com.deepak.backend.Services;

import com.deepak.backend.Beans.View;
import com.deepak.backend.Beans.ViewData;

import com.deepak.backend.DAO.ViewDataDAO;

import java.util.List;

public class ViewDataService {

    public final ViewDataDAO dao = new ViewDataDAO();
    public boolean addViewData(ViewData viewData) {
        return dao.addViewData(viewData);
    }

    public List<ViewData> getCompleteViewData(View view_id) {
        List<ViewData> resultSet = dao.getCompleteViewData(view_id.getView_id());
        return resultSet;
    }

}

