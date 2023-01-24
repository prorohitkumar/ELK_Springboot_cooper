import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConversationComponent } from './components/conversation/conversation.component';
import { MatDividerModule } from '@angular/material/divider';
import { FlexLayoutModule } from '@angular/flex-layout';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { AnswerDialogComponent } from './components/answer-dialog/answer-dialog.component';
// import { SimpleNgLoaderModule } from 'simple-ng-loader'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { AnswerComponent } from './components/answer/answer.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatTooltipModule} from '@angular/material/tooltip';

@NgModule({
  declarations: [
    AppComponent,
    ConversationComponent,
    ToolbarComponent,
    FooterComponent,
    AnswerDialogComponent,
    AnswerComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatDividerModule,
    FlexLayoutModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule,
    MatTooltipModule
    // SimpleNgLoaderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
