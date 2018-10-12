from rest_framework import serializers
from .models import Writings


class WritingSerializer(serializers.ModelSerializer):
    class Meta:
        model = Writings
        fields = "__all__"
