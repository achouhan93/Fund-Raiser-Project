<template>
  <form class="form-inline">
    <div class="container">
      <div class="col-md-11 col-md-offset-12 section-title">
        <div class="text-center">
          <h2>Fund Raiser</h2>
          <br>
          <div class="card bg-dark">
            <div class="card-body">
              <p class="card-text">If you’re raising money for a non-profit, then you might want to look into Fund Raiser!

                Unlike the other fundraising options, Fund Raiser is focused on giving programs for nonprofits, corporations, and events.

                That being said, you can also raise money for individual causes using Fund Raiser. Individuals that are part of a “fundraising team” can also use this platform.
              </p>
            </div>
          </div>
          <h2>Meet the Team</h2>
        </div>
      </div>
      <v-container fluid>
        <v-layout justify-space-around>
          <v-flex xs5>
            <v-layout column>
              <div class="thumbnail"> <img src="../assets/ashish.png" alt="..." class="team-img" height="100px">
                <div class="caption">
                  <div class="title mb-1">Ashish</div>
                </div>
              </div>
            </v-layout>
          </v-flex>

          <v-flex xs5>
            <v-layout column>
              <div class="thumbnail"> <img src="../assets/IMG_20190328_234803_180.jpg" alt="..." class="team-img" height="100px">
                <div class="caption">
                  <div class="title mb-1">Hitesh</div>
                </div>
              </div>
            </v-layout>
          </v-flex>
          <v-flex xs5>
            <v-layout column>
              <div class="thumbnail"> <img src="../assets/nik.png" alt="..." class="team-img" height="100px">
                <div class="caption">
                  <div class="title mb-1">Nikhil</div>
                </div>
              </div>
            </v-layout>
          </v-flex>
          <v-flex xs5>
            <v-layout column>
              <div class="thumbnail"> <img src="../assets/pan.png" alt="..." class="team-img" height="100px">
                <div class="caption">
                  <div class="title mb-1">Paneesh</div>
                </div>
              </div>
            </v-layout>
          </v-flex> <v-flex xs5>
          <v-layout column>
            <div class="thumbnail"> <img src="../assets/11010856.png" alt="..." class="team-img" height="100px">
              <div class="caption">
                <div class="title mb-1">Sanket</div>
              </div>
            </div>
          </v-layout>
        </v-flex>
        </v-layout>
      </v-container>
    <br>
    <div class="col-md-11 col-md-offset-1 section-title">
      <div class="contact-item">
        <h2>Contact Us @</h2>
        <p><span><i class="fa fa-map-marker"></i></span>SRH University Heidelberg <br>
          Ludwig-Guttmann-Strasse 6,<br> 69123 Heidelberg, Germany</p>
      </div>
      <div class="contact-item">
        <p><span><i class="fa fa-phone"></i> Phone:</span> +49 123 456 1234</p>
      </div>
      <div class="contact-item">
        <p><span><i class="fa fa-envelope-o"></i> Email:</span> srh@hochschule-heidelberg.com</p>
      </div>
    </div>
    </div>
  </form>

</template>
<style scoped>
  img {
    border-radius: 50%;
  }
</style>
