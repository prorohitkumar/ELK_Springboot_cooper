import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ChatServiceService } from 'src/app/services/chat-service.service';
import { Question } from '../../model/question'
import {MatDialog } from '@angular/material/dialog';
import { AnswerDialogComponent } from '../answer-dialog/answer-dialog.component';
import Typewriter from 't-writer.js'
import { waitForAsync } from '@angular/core/testing';

@Component({
  selector: 'app-conversation',
  templateUrl: './conversation.component.html',
  styleUrls: ['./conversation.component.css']
})
export class ConversationComponent implements OnInit {

  chatFormGroup: FormGroup;
  chatObject: Question = new Question();
  // answer: string="Angular is an open-source front-end web application framework mainly maintained by Google and by a community of individuals and corporations to address many of the challenges encountered in developing single-page applications. It aims to simplify both the development and the testing of such applications by providing a framework for client-side model–view–controller (MVC) and model–view–viewmodel (MVVM) architectures, along with components commonly used in rich Internet applications.Angular is an open-source front-end web application "
  answer: string;
  apiCalled: boolean = false;

  target: any;
  waitWriter: any;
  answerWriter: any;
  
  constructor(private prop: FormBuilder, private chatService: ChatServiceService, public dialog: MatDialog) { }

  ngOnInit(): void {

    this.chatFormGroup = new FormGroup({
      question: new FormControl("",[Validators.required,Validators.minLength(3)])
    })

  this.target = document.querySelector('.answer-div');
  // this.waitWriter = new Typewriter(this.target, {
  //       loop: true,
  //       typeColor: 'red',
  //       typeSpeed: 10,
  //     })
  // this.answerWriter = new Typewriter(this.target, {
  //     loop: false,
  //     typeColor: 'green',
  //     typeSpeed: 100,
  //   })
  }

  writerInit(){
    this.waitWriter = new Typewriter(this.target, {
      loop: true,
      typeColor: 'red',
      typeSpeed: 10,
    })
this.answerWriter = new Typewriter(this.target, {
    loop: false,
    typeColor: 'green',
    typeSpeed: 100,
  })
}
  postNewProperty() {
    console.log("Asked")
    this.chatObject.question = this.chatFormGroup.value.question;
    if (this.chatObject.question.length>2) {
      this.writerInit();
      this.apiCalled=true;
      this.waitForAnswer();
      this.chatService.Chat(this.chatObject).subscribe(data => {
      this.apiCalled=false;
      console.log(data.answer);
      this.answer = data.answer;
      if (this.answer!=null) {
        this.startTyping();
      }
      })
    }
  }

  waitForAnswer(){
      this.waitWriter
        .type(".....")
        .rest(500)
        .removeCursor()
        .start()
    }

  startTyping() {
    this.waitWriter
      .remove()
    this.answerWriter
      .type(this.answer)
      .rest(500)
      .removeCursor()
      .start()
    }

  clear(){
    console.log("clearing");
    this.chatFormGroup.reset();
    this.target.innerHTML = "";
  }
}
