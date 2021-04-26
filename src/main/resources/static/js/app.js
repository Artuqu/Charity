document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            //step init
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    //validation to events
                    if (this.validate()) {
                        this.currentStep++;
                        this.updateForm();
                    }
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */


        // TODO: Validation
        validate() {
            //            step 1
            if (this.currentStep === 1) {
                let categories = form.querySelectorAll("input[type='checkbox']:checked");
                let counter = 0;
                for (let i = 0; i < categories.length; i++) {
                    if (categories[i].checked) {
                        counter++
                    }
                }
                if (counter > 0) {
                    return true;
                }
                else {
                    alert("Wybierz co najmniej jedną opcję.");
                    return false;
                }
                //                step 2
            } else if (this.currentStep === 2) {
                let bagQuantity = form.querySelector("input[type='number']");
                if (bagQuantity.value <= 0) {
                    alert("Musisz oddać conajmniej jeden worek.");
                    return false;
                }
                else {
                    return true;
                }
            }
            //               step 3
            else if (this.currentStep === 3) {
                let institutionName = form.querySelector("input[type='radio']:checked");
                if (institutionName !== null) {
                    return true;
                }
                else {
                    alert("Wybierz organizację.");
                    return false;
                }
            }
            //                step 4
            else if (this.currentStep === 4) {

                let divInput = document.querySelectorAll("div[data-step='4'] div[class='form-section form-section--columns'] input[type='text']");
                let errorCounter = 0;
                let street = divInput[0].value;
                let errorStreet = document.getElementById("errorStreet");
                if (street === "") {
                    errorStreet.innerHtml = "Podaj nazwę ulicy.";
                    errorCounter++;
                } else {
                    errorStreet.innerHtml = "";
                }

                let city = divInput[1].value;
                let errorCity = document.getElementById("errorCity");
                if (city === "") {
                    errorCity.innerText = "Podaj nazwę miasta.";
                    errorCounter++;
                } else {
                    errorCity.innerText = "";
                }

                let zipCode = divInput[2].value;
                let errorZipCode = document.getElementById("errorZipCode");
                if (zipCode === "") {
                    errorZipCode.innerText = "Podaj kod pocztowy.";
                    errorCounter++;
                } else {
                    errorZipCode.innerText = "";
                }

                return errorCounter <= 0;
            }
        }

        // TODO: get data from inputs and show them in summary
        updateForm() {
            this.$step.innerText = this.currentStep;


            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;
            let categories = form.querySelectorAll("input[type='checkbox']:checked");

            let categoriesText = [];
            for (let checkbox of categories) {
                categoriesText.push(checkbox.parentNode.lastElementChild.textContent);
            }

            console.log(categoriesText);

            let bagQuantityElement = form.querySelector("input[type='number']").value;

            let donationDetails = document.querySelectorAll("div[data-step='5'] .summary div[class='form-section'] .summary--text");
            console.log(donationDetails);
            let numberOfBags = donationDetails[0];
            console.log(bagQuantityElement);
            if (bagQuantityElement < 2) {
                numberOfBags.innerText = bagQuantityElement + " worek zawierający " + categoriesText.join(" oraz ");
            } else if (bagQuantityElement < 5) {
                numberOfBags.innerText = bagQuantityElement + " worki zawierające " + categoriesText.join(" oraz ");
            } else {
                numberOfBags.innerText = bagQuantityElement + " worków zawierających " + categoriesText.join(" oraz ");
            }

            let address = form.querySelectorAll("div[data-step='4'] div[class='form-section form-section--columns'] input[type='text']");
            let street = address[0].value;
            let city = address[1].value;
            let zipcode = address[2].value;
            let phone = document.querySelector("input[type='phone']").value;
            let pickUpDate = document.querySelector("input[type='date']").value;
            let pickUpTime = document.querySelector("input[type='time']").value;
            let pickUpComments = document.querySelector("textarea").value;

            const contactDetails = form.querySelectorAll("div[data-step='5'] .summary div[class='form-section form-section--columns'] ul li");
            contactDetails[0].innerText = street;
            contactDetails[1].innerText = city;
            contactDetails[2].innerText = zipcode;
            contactDetails[3].innerText = phone;
            contactDetails[4].innerText = pickUpDate;
            contactDetails[5].innerText = pickUpTime;
            contactDetails[6].innerText = pickUpComments;

            let institutions = form.querySelector("input[type='radio']:checked").parentNode.lastElementChild.firstElementChild.textContent;
            let institutionText = donationDetails[1];
            institutionText.innerText = "Dla fundacji " + institutions;
        }






    }



    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }
});
