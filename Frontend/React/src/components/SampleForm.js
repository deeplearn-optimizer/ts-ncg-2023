import React from "react";
import "../styles/uikit.css";

const SampleForm = () => {
  return (
    <div class = "form_new"> 
    <form action="#" class="form">
      <div class="form__field">
        <label for="formInput#text">Full Name: </label>
        <input
          class="input input--text"
          id="formInput#text"
          type="text"
          name="text"
          placeholder="Enter your full name"
        />
      </div>

      <div class="form__field">
        <label for="formInput#email">Email: </label>
        <input
          class="input input--email"
          id="formInput#email"
          type="email"
          name="email"
          placeholder="e.g. user@domain.com"
        />
      </div>

      <div class="form__field">
        <label for="formInput#password">Password: </label>
        <input
          class="input input--password"
          id="formInput#passowrd"
          type="password"
          name="password"
          placeholder="••••••••"
        />
      </div>

      <div class="form__field form__field--radio">
        <p>Favorite Color:</p>
        <input
          class="input input--radio"
          id="formInput#radio-01"
          type="radio"
          value="red"
          name="color"
        />
        <label for="formInput#radio-01">Red</label>
        <input
          class="input input--radio"
          id="formInput#radio-02"
          type="radio"
          value="green"
          name="color"
        />
        <label for="formInput#radio-02">Green</label>
        <input
          class="input input--radio"
          id="formInput#radio-03"
          type="radio"
          value="blue"
          name="color"
        />
        <label for="formInput#radio-03">Blue</label>
      </div>

      <div class="form__field form__field--checkbox">
        <p>Your Hobby:</p>
        <input
          class="input input--checkbox"
          id="formInput#checkbox-01"
          type="checkbox"
          value="riding"
          name="hobby"
        />
        <label for="formInput#checkbox-01">Riding Bike</label>
        <input
          class="input input--checkbox"
          id="formInput#checkbox-02"
          type="checkbox"
          value="surfing"
          name="hobby"
        />
        <label for="formInput#checkbox-02">Surfing Sea</label>
        <input
          class="input input--checkbox"
          id="formInput#checkbox-03"
          type="checkbox"
          value="brewing-beer"
          name="hobby"
        />
        <label for="formInput#checkbox-03">Brewing Beer</label>
      </div>

      <div class="form__field">
        <label for="formInput#textarea">Message: </label>
        <textarea
          class="input input--textarea"
          name="message"
          id="formInput#textarea"
          placeholder="Write something awesome..."
        ></textarea>
      </div>

      <div class="form__field form__field--action">
        <input class="btn" type="reset" value="Reset" />
        <input class="btn btn--main" type="submit" value="Submit" />
      </div>
    </form>
    </div>
  );
};



export default SampleForm;