[![](https://www.jitpack.io/v/stanhe/CustomDialog.svg)](https://www.jitpack.io/#stanhe/CustomDialog)
![](https://img.shields.io/dub/l/vibe-d.svg?maxAge=2592000)

# CustomDialog
继承DialogFragment，方便使用的自定义dialog
## Feature
#### 轻量级封装
    与自定义dialog extends DialogFragment 所需实现基本相同，并简化代码，预处理窗口
#### 窗口大小控制 
    添加 setSize(w,h)方法, w/h 可以是百分比浮点数，或者指定dp 确定dialog的大小。(-1 = match_parent ,-2 = wrap_content)
#### 动画及拓展(进入/退出动画，展示动画)
    拓展动画实现方式，可以 [自定义动画实现](https://github.com/stanhe/CustomDialog/blob/0c92046ca24b6b62c7b2bbd06030388e83d67559/app/src/main/java/com/stan/customdialogfragment/CustomDialog.java#L31)。接口方式只提供基本的cancel、confirm，应优先考虑在子类中拓展自定义接口和其他实现

## Usage
   Step 1. Add the [JitPack dependence](https://www.jitpack.io/#stanhe/CustomDialog/1.0.1)

   Step 2. create a [CustomDialog](https://github.com/stanhe/CustomDialog/blob/master/app/src/main/java/com/stan/customdialogfragment/CustomDialog.java)
   
   Step 3. [use dialog](https://github.com/stanhe/CustomDialog/blob/master/app/src/main/java/com/stan/customdialogfragment/MainActivity.java)
   
## LICENSE
   See [license](https://github.com/stanhe/CustomDialog/blob/master/LICENSE) (MIT)
