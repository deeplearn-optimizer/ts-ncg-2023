import React, { useState } from "react";
import { useRef } from "react";
import CanvasJSReact from '@canvasjs/react-charts';

import "../styles/uikit.css";

var CanvasJS = CanvasJSReact.CanvasJS;
var CanvasJSChart = CanvasJSReact.CanvasJSChart;

const ChartForm = () => {
  const countryRef = useRef();
  const startDateRef = useRef();
  const endDateRef = useRef();
  const IndicatorRef = useRef();
  const chartRef = useRef();

  const [options, setOptions] = useState({}) 

  const submitHandler = async (event) => {
    event.preventDefault();

    const country = countryRef.current.value; 
    const start_date = startDateRef.current.value; 
    const end_date = endDateRef.current.value; 
    const indicator = IndicatorRef.current.value; 
    const chart = chartRef.current.value; 

    const data = {
      "country": countryRef.current.value,
      "indicator" : IndicatorRef.current.value,
      "startDate" : startDateRef.current.value,
      "endDate" : endDateRef.current.value
  }
  

    console.log(data);

    const url = "http://localhost:8080/view"  
    const response = await fetch(url, {
      method: 'POST',
      mode:'cors',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });
    const json_data = await response.json();

    console.log(json_data)


    const filteredData = json_data.filter((item) => {
      const year = item.date;
      return year >= startDateRef.current.value && year <= endDateRef.current.value;
    });

    console.log(filteredData)
    const datapoints = filteredData.map(item => {return ({ label : item.date, y : item.value})})

    const temp_options = {
			title: {
				text: IndicatorRef.current.value + " " + countryRef.current.value
			},
			data: [
			{
				// Change type to "doughnut", "line", "splineArea", etc.
				type: chart,
				dataPoints: datapoints
			}
			]
		}
    setOptions(temp_options)

  }



  return (
    <>
    <div class="form_new">
      <form onSubmit={submitHandler} class="form">
        <div class="form__field">
          <label for="formInput#text">Contry: </label>
          <input
            class="input input--text"
            id="formInput#text"
            type="country"
            name="country"
            ref={countryRef}
          />
        </div>

        <div class="form__field">
          <label for="formInput#text">Start date: </label>
          <input
            class="input input--text"
            id="formInput#text"
            type="start_date"
            name="start_date"
            ref={startDateRef}
          />
        </div>

        <div class="form__field">
          <label for="formInput#text">End date: </label>
          <input
            class="input input--text"
            id="formInput#text"
            type="endDate"
            name="endDate"
            ref={endDateRef}
          />
        </div>

        <div class="form__field">
          <label for="formInput#text">Indicator: </label>
          <input
            class="input input--text"
            id="formInput#text"
            type="Indicator"
            name="Indicator"
            ref={IndicatorRef}
          />
        </div>

        <div class="form__field">
          <label for="formInput#text">Chart: </label>
          <input
            class="input input--text"
            id="formInput#text"
            type="chart"
            name="chart"
            ref={chartRef}
          />
        </div>


        <div class="form__field form__field--action">
          <input class="btn" type="reset" value="Reset" />
          <input class="btn btn--main" type="submit" value="Submit" />
        </div>
      </form>
    </div>

 
    {options.hasOwnProperty("title") ? <CanvasJSChart options = {options} /> : ""}
    </>
  );
};

export default ChartForm;
