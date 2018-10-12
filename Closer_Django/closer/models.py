# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey has `on_delete` set to the desired behavior.
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class ChattingRecords(models.Model):
    user = models.ForeignKey('Users', models.DO_NOTHING, db_column='user_ID')  # Field name made lowercase.
    class_field = models.ForeignKey('Class', models.DO_NOTHING, db_column='class_ID')  # Field name made lowercase. Field renamed because it was a Python reserved word.
    question = models.ForeignKey('Question', models.DO_NOTHING, db_column='question_ID')  # Field name made lowercase.
    record_content = models.CharField(max_length=30)
    time = models.DateTimeField()

    class Meta:
        managed = False
        db_table = 'chatting records'


class Class(models.Model):
    class_id = models.AutoField(db_column='class_ID', primary_key=True)  # Field name made lowercase.
    class_content = models.CharField(db_column='class_ content', max_length=30)  # Field renamed to remove unsuitable characters.

    class Meta:
        managed = False
        db_table = 'class'


class Hello(models.Model):
    hello_id = models.AutoField(db_column='hello_ID', primary_key=True)  # Field name made lowercase.
    hello_content = models.CharField(max_length=30)

    class Meta:
        managed = False
        db_table = 'hello'


class Question(models.Model):
    class_field = models.ForeignKey(Class, models.DO_NOTHING, db_column='class_ID')  # Field name made lowercase. Field renamed because it was a Python reserved word.
    question_id = models.AutoField(db_column='question_ID', primary_key=True)  # Field name made lowercase.
    question_content = models.CharField(max_length=30)

    class Meta:
        managed = False
        db_table = 'question'


class Users(models.Model):
    user = models.ForeignKey(ChattingRecords, models.DO_NOTHING, db_column='user_ID', primary_key=True)  # Field name made lowercase.
    user_name = models.CharField(max_length=20)
    gender = models.CharField(max_length=2)
    image = models.TextField()
    email = models.CharField(unique=True, max_length=20)
    facebook_user = models.CharField(unique=True, max_length=20)
    google_user = models.CharField(unique=True, max_length=20)

    class Meta:
        managed = False
        db_table = 'users'


class Writings(models.Model):
    writings_id = models.AutoField(db_column='writings_ID', primary_key=True)  # Field name made lowercase.
    writings_name = models.CharField(max_length=255)
    writings_content = models.TextField(db_column='writings_ content')  # Field renamed to remove unsuitable characters.
    notes = models.CharField(max_length=255)

    class Meta:
        managed = False
        db_table = 'writings'

    def __str__(self):
        return self.writings_name

