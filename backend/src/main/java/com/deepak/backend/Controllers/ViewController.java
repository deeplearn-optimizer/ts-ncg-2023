package com.deepak.backend.Controllers;

import com.deepak.backend.Beans.View;
import com.deepak.backend.Beans.ViewData;
import com.deepak.backend.Services.ViewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ViewController {

    private final ViewService service = new ViewService();
    @PostMapping(path = "view",consumes = "application/json")
    public ResponseEntity<List<ViewData>>  addView(@RequestBody View view) {

        try {
            List<ViewData> views = service.addViewData(view);
            if (views == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            } else {
                return ResponseEntity.ok(views);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "view")
    public ResponseEntity<List<View>> getViews() {
        List<View> views = service.getAllViews();
        if (views == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        } else {
            return ResponseEntity.ok(views);
        }
    }

    @GetMapping(path = "view/{view_id}")
    public ResponseEntity<View> getViewById(@PathVariable String view_id) {
        try {
            List<View> views = service.getViewById(Long.parseLong(view_id));
            if (views == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            } else {
                return ResponseEntity.ok(views.get(0));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @GetMapping(path = "view_data/{view_id}")
    public ResponseEntity<List<ViewData>> getViewDataById(@PathVariable String view_id) {
        try {
            List<ViewData> views = service.getViewDataBYID(Long.parseLong(view_id));
            if (views == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            } else {
                return ResponseEntity.ok(views);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @GetMapping(path = "delete/{view_id}")
    public ResponseEntity<HttpStatus> deleteViewById(@PathVariable String view_id) {

            if(service.deleteViewByID(Long.parseLong(view_id))) {
                return new ResponseEntity<HttpStatus>(HttpStatus.OK);
            }
        return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);

    }






}
