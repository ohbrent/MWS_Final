#from django.urls import path
#from . import views
#urlpatterns = [
#    path('', views.post_list, name='post_list'),
#]
from django.urls import path
from . import views
from django.conf.urls.static import static
from django.conf import settings

from django.urls import include
from rest_framework import routers

router = routers.DefaultRouter()
router.register('Post', views.blogImage)

urlpatterns = [
    path('', views.post_list, name='post_list'),
    path('post/<int:pk>/', views.post_detail, name='post_detail'), 
    path('post/new/', views.post_new, name='post_new'),
    path('post/<int:pk>/edit/', views.post_edit, name='post_edit'),
    path('api_root/', include(router.urls)),
]

urlpatterns += static(settings.STATIC_URL,document_root=settings.STATIC_ROOT)
urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)