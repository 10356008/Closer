from django.http import HttpResponseRedirect
from django.shortcuts import render
from django import forms

from rest_framework import viewsets
from rest_framework.views import APIView
from rest_framework.response import Response
from .models import Writings
from .serializers import WritingSerializer


def index(request):
    posts = Writings.objects.order_by('writings_id')
    return render(request, 'closer/index.html', {'posts': posts})


class WritingsForm(forms.ModelForm):
    class Meta:
        model = Writings
        fields = ['writings_name', 'writings_content', 'notes']


class WrintingsViewSet(viewsets.ModelViewSet):
    queryset = Writings.objects.all()
    serializer_class = WritingSerializer


class WrintingList(APIView):
    def get(self, request):
        allpost = Writings.objects.all()
        serializer = WritingSerializer(allpost, many=True)
        return Response(serializer.data)

    def post(self):
        pass


def create(request):
    if request.method == 'POST':
        form = WritingsForm(request.POST)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect('/closer/create/ok')
    form = WritingsForm()
    return render(request, 'closer/create.html', {'form': form})


def create_ok(request):
    message = "新增成功"
    return render(request, 'closer/create_ok.html', {'message': message})


