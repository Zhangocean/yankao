﻿/*
*	全国三级城市联动 js版
*/







 var jiaArr = ["请选择","北京","上海","天津","重庆","黑龙江","吉林","辽宁","山东","山西","陕西","河北","河南","湖北","湖南","海南","江苏","江西","广东","广西","云南","贵州","四川","内蒙古","宁夏","甘肃","青海","西藏","新疆","安徽","浙江","福建","台湾","香港","澳门"];
        var exampleArr = [
                ["请选择"],
                
["清华大学","北京大学","中国人民大学","北京航空航天大学","北京邮电大学","北京师范大学","中国传媒大学","北京语言大学","北京科技大学","中国农业大学","北京理工大学","北京林业大学","北京交通大学","中国矿业大学（北京）","北京信息科技大学","北京工业大学","北京化工大学","中国政法大学","对外经贸大学","中央民族大学","中国地质大学（北京）","中科院","北京中医药大学","首都经济贸易大学","中央财经大学","北方工业大学","中国石油大学（北京）","外交学院","首都师范大学","中央戏剧学院","中国青年政治学院","北京外国语大学","华北电力大学（北京）","中国人民公安大学","中国协和医科大学","北京体育大学","北京工商大学","北京联合大学","首都医科大学","国际关系学院","中央美术学院","北京电子科技学院","中国劳动关系学院","中华女子学院","北京建筑工程学院","北京印刷学院","北京石油化工学院","首钢工学院","北京农学院","首都体育学院","北京第二外国语学院","北京物资学院","北京警察学院","中央音乐学院","中国戏曲学院","北京舞蹈学院","北京城市学院","北京电影学院","北京服装学院","北京工商大学嘉华学院","首都师范大学科德学院","北京工业大学耿丹学院","北京化工大学北方学院","北京联合大学广告学院","北京邮电大学世纪学院","北京大学医学部","北京政法职业学院","北京信息职业技术学院","北京现代职业技术学院","北京现代音乐研修学院","北京戏曲艺术职业学院","北京锡华国际经贸职业学院","北京盛基艺术学校","北京培黎职业学院","北京农业职业学院","北京科技职业学院","北京科技经营管理学院","北京经贸职业学院","北京经济技术职业学院","北京京北职业技术学院","北京交通职业技术学院","北京吉利大学","北京汇佳职业学院","北京工业职业技术学院","北京工商管理专修学院","北京电子科技职业学院","北京财贸职业学院","北京北大方正软件技术学院","北大资源美术学院","北京人文大学","北京高等秘书学院","北京应用技术大学","中国防卫科技学院","中国音乐学院","中国信息大学","北京青年政治学院","北京财经专修学院","北京经济管理职业学院","北京美国英语语言学院","中国管理软件学院","财政部财政科学研究所","北大资源学院","北京现代管理大学","网络销售大学","朝阳二外"],["复旦大学","上海交通大学","同济大学","华东师大","上海财经","华东理工","上海商学院","东华大学","上海理工","上海大学","上外","上海海事","上海工程"],["南开大学","天津大学","河北工大","天津师大","天津工大","天津科大","天津理工","天津医大","天津中医药","天津财经","中国民航大学"],["重庆大学","西南大学","重庆师大","西南政法","重庆交大","重庆邮电大学","重庆医大","重庆工商","重庆科技学院","重庆工学院","长江师范学院","四川外国语","四川美院"],["哈工大","哈工程","东北林大","东北农大","哈尔滨医科大","黑龙江中医药","黑工程","黑龙江科技大学","哈尔滨学院","哈尔滨体院","东方学院","黑龙江大学","哈尔滨商业大学","哈师大","哈理工","佳木斯大学","齐齐哈尔大学","齐齐哈尔医学院"],["吉林大学","东北师范大学","长春大学","吉林农大","长春中医药","东北电力大学","吉林化工","吉林建筑","长春工程学院","长春师范学院","吉林工程师范","吉林华桥外语","长春税务","吉林体院","吉林艺术学院","长春工大","长春理工","延边大学"],["大连理工","东北大学","辽宁大学","大连海事","东北财经","大连大学","大连交大","大连医大","辽宁师大","大连民族","大连工大","大连水产","大连外国语学院"],["山东大学","中国海洋大学","济南大学","山东建筑大学","山东师大","山东经济学院","山东中医药","山东轻工","山东交通学院","山东警院","山东体院","山东艺术学院","山东工美","曲阜师大","烟台大学","鲁东大学","山东工商","南山学院","青岛大学","山东科大","青岛科大","青岛理工"],["山西大学","太原理工","中北大学","山西医大","山西中医学院","太原师范","太原科大","山西财经","山西师大","山西农大","大同大学"],["西安交大","长安大学","西北工大","西北大学","陕西师大","西安电子科大","西安理工","西安科大","西安工大","西外","西邮","西安医学院","西安财经","西北政法","西安体院","西安美院","西安音乐学院","西安文理学院","西京学院","西安翻译学院","培华学院","欧亚学院","西安外事","西安石油","西安建筑科大","第四军医大学","西安电子科技大学高等职业技术学院"],["河北大学","河北农大","中央司法警官学院","石家庄铁院","石家庄经院","河北师大","河北科技","河北医科","河北经贸","河北体院","石家庄学院","燕山大学","河北科师","河北理工","华北煤炭医学","唐山学院","唐山师范","华北航工","廊坊师范"],["郑州大学","河南工业","河南农大","华北水利水电","郑州轻工","郑州航空工业","黄河科技","中原工学院","河南中医学院","河南财经","河南大学","河南科技大学","洛阳师院","安阳工学院","安阳师院","南阳理工","南阳师院","平顶山工学院","平顶山学院"],["武汉大学","华中科大","华中农大","武汉理工","中国地质大学（武汉）","中南财经政法","中南民族大学","华中师大","武汉工业学院","武汉科技学院","湖北中医学院","湖北经济学院","湖北警官学院","武汉体院","湖北美院","武汉音乐学院","武汉生物工程学院","湖北工大"],
["湖南师大","中南大学","湖南大学","长沙理工","湖南农大","湖南中医药","中南林业科大","长沙学院","长沙医学院","湖南涉外经济","湖南商学院"],["海南大学","海南医学院","海南师范大学","华南热带农大","琼州大学","海口经济职业技术学院","海南经贸职业技术学院","海南软件职业技术学院","海南外国语职业学院","海南万和信息职业技术学院","海南政法职业学院","海南职业技术学院"],["南京大学","河海大学","南京师大","南京理工","东南大学","南航","南京财经","南京医科大","南京工大"],["江西财经","南昌大学","华东交通大学","南昌航空大学","南昌工程","南昌理工","江西中医学院","江西科技师范学院","蓝天学院","江西农大","江西师大","东华理工大学","景德镇陶瓷学院","赣南医学院","赣南师范学院","江西理工","上饶师范学院"],["华南理工大学","中山大学","暨南大学","华南师范大学","广东工业大学","华南农业大学","广州大学","广东外语外贸大学","广州中医药大学","南方医科大学"],["广西大学","广西医科大学","广西民族大学","广西中医学院","广西师范学院","广西财经学院","广西艺术学院","桂林电子科技大学","广西师范大学","桂林工学院"],["昆明理工","云南农大","云南师大","云南财经","云南民大","西南林学院","昆明医学院","云南中医学院","红河学院","云南警官学院"],["贵州大学","贵阳医学院","贵阳中医学院","贵州财经","贵州民族","贵阳学院","贵州师大","铜仁学院"],["四川大学","四川农大","电子科大","西南交大","成都理工","四川师大","西南民族大学","成都大学","西南财经","西华大学","成都中医药"],["内蒙古大学","内蒙古工业大学","内蒙古农大","内蒙古师大","内蒙古医学院","内蒙古财经","内蒙古科大","内蒙古民族大学","赤峰学院","呼伦贝尔学院","包头钢铁职业技术学院","包头轻工职业技术学院","包头职业技术学院","河套大学","呼和浩特职业学院","集宁师范高等专科学校","科尔沁艺术职业学院","内蒙古财税职业学院","内蒙古电子信息职业技术学院","内蒙古青城大学","内蒙古化工职业学院","内蒙古机电职业技术学院","内蒙古建筑职业技术学院","内蒙古交通职业技术学院","内蒙古民族高等专科学校","内蒙古商贸职业学院","内蒙古体育职业学院","通辽职业学院","乌海职业技术学院","乌兰察布职业学院","锡林郭勒职业学院","兴安职业技术学院","内蒙古警察职业学院","内蒙古北方职业技术学院","内蒙古丰州学院","内蒙古经贸外语职业学院","内蒙古科技职业学院","赤峰职业技术学院"],["宁夏大学","北方民大","宁夏医学院","宁夏理工","宁夏师范","吴忠职业技术学院","宁夏职业技术学院","宁夏财经职业技术学院","宁夏司法警官职业学院"],["兰州大学","西北民大","西北师大","甘肃中医学院","兰州商院","甘肃政法学院","兰州城市学院","甘肃农大","兰州理工","兰州交大","天水师院","陇东学院"],["青海大学","青海师大","青海民院","青海民族师范高等专科学校"],["西藏大学","西藏藏医学院","西藏民院","拉萨师范高等专科学校","西藏警官高等专科学校","西藏职业技术学院"],["新疆大学","新疆农大","新疆医科大","新疆师大","新疆财经","新疆艺术学院","石河子大学","塔里木大学","喀什师院","伊犁师院"],["中国科大","安徽大学","合肥工大","安徽医科大","安徽建工","安徽中医","合肥学院","安徽农大","安徽工业大学","安徽科技","皖南医学院","安徽师大"],["浙江大学","浙江理工","浙江工大","杭州电子科大","浙江中医药","浙江工商","中国计量","浙江科技","浙江林院","杭州师范","浙江传媒","浙江财经"],["厦门大学","集美大学","厦门理工学院","福州大学","福建师范大学","福建农林大学","福建医科大学","福建工程学院","福建中医学院","闽江学院","华侨大学","仰恩大学","泉州师范学院","漳州师范","莆田学院","三明学院","龙岩学院","厦门大学嘉庚学院"],["国立台湾大学","国立中正大学","国立台湾艺术大学","国立清华大学","国立中山大学","国立政治大学","国立成功大学","国立中央大学","国立阳明大学","国立东华大学","国立中兴大学","国立台湾师范大学","国立台湾海洋大学","国立高雄大学","国立嘉义大学","国立台湾科技大学","国立空中大学","国立台北大学","国立高雄师范大学","国立联合大学","国立暨南国际大学","国立屏东科技大学","国立彰化师范大学","国立台北科技大学","国立台东大学","国立宜蓝大学","国立台北艺术大学","国立云林科技大学","国立台南大学","国立虎尾科技大学","国立花莲教育大学","国立高雄第一科技大学","国立屏东教育大学","国立新竹教育大学","国立澎湖科技大学","建国科技大学","国立台南艺术大学","国立高雄应用科技大学"],["香港大学","香港中文大学","香港科技大学","香港理工大学","香港城市大学","香港浸会大学","香港岭南大学"],["澳门大学","澳门理工学院","澳门科技大学","澳门旅游学院","澳门镜湖护理学院","澳门国际公开大学"]        ];
        window.onload = function () {
             ChangeExampleSelect(0);
            var selJia = document.getElementById("jia");
            //申请空间
            selJia.length = jiaArr.length;
            //添加元素
            for (var i = 0; i <jiaArr.length; i++) {
                selJia.options[i].text = jiaArr[i];
                selJia.options[i].value = jiaArr[i];
            }
        }
 
        function ChangeExampleSelect(index)
        {
            var selExa = document.getElementById("example");
 
            selExa.length = exampleArr[index].length;
 
            for (var i = 0; i < exampleArr[index].length; i++)
            {
                selExa.options[i].text = exampleArr[index][i];
                selExa.options[i].value = exampleArr[index][i];
            }
        }

/*
*	全国三级城市联动 js版
*/
function Dsy(){
	this.Items = {};
}
Dsy.prototype.add = function(id,iArray){
	this.Items[id] = iArray;
}
Dsy.prototype.Exists = function(id){
	if(typeof(this.Items[id]) == "undefined") return false;
	return true;
}

function change(v){
	var str="0";
	for(i=0;i<v;i++){
		str+=("_"+(document.getElementById(s[i]).selectedIndex-1));
	};
	var ss=document.getElementById(s[v]);
	with(ss){
		length = 0;
		options[0]=new Option(opt0[v],opt0[v]);
		if(v && document.getElementById(s[v-1]).selectedIndex>0 || !v){
			if(dsy.Exists(str)){
				ar = dsy.Items[str];
				for(i=0;i<ar.length;i++){
					options[length]=new Option(ar[i],ar[i]);
				}//end for
				if(v){ options[0].selected = true; }
			}
		}//end if v
		if(++v<s.length){change(v);}
	}//End with
}

var dsy = new Dsy();

dsy.add("0",["北京","上海","天津","重庆","黑龙江","吉林","辽宁","山东","山西","陕西","河北","河南","湖北","湖南","海南","江苏","江西","广东","广西","云南","贵州","四川","内蒙古","宁夏","甘肃","青海","西藏","新疆","安徽","浙江","福建","台湾","香港","澳门"]);
dsy.add("0_0",["清华大学","北京大学","中国人民大学","北京航空航天大学","北京邮电大学","北京师范大学","中国传媒大学","北京语言大学","北京科技大学","中国农业大学","北京理工大学","北京林业大学","北京交通大学","中国矿业大学（北京）","北京信息科技大学","北京工业大学","北京化工大学","中国政法大学","对外经贸大学","中央民族大学","中国地质大学（北京）","中科院","北京中医药大学","首都经济贸易大学","中央财经大学","北方工业大学","中国石油大学（北京）","外交学院","首都师范大学","中央戏剧学院","中国青年政治学院","北京外国语大学","华北电力大学（北京）","中国人民公安大学","中国协和医科大学","北京体育大学","北京工商大学","北京联合大学","首都医科大学","国际关系学院","中央美术学院","北京电子科技学院","中国劳动关系学院","中华女子学院","北京建筑工程学院","北京印刷学院","北京石油化工学院","首钢工学院","北京农学院","首都体育学院","北京第二外国语学院","北京物资学院","北京警察学院","中央音乐学院","中国戏曲学院","北京舞蹈学院","北京城市学院","北京电影学院","北京服装学院","北京工商大学嘉华学院","首都师范大学科德学院","北京工业大学耿丹学院","北京化工大学北方学院","北京联合大学广告学院","北京邮电大学世纪学院","北京大学医学部","北京政法职业学院","北京信息职业技术学院","北京现代职业技术学院","北京现代音乐研修学院","北京戏曲艺术职业学院","北京锡华国际经贸职业学院","北京盛基艺术学校","北京培黎职业学院","北京农业职业学院","北京科技职业学院","北京科技经营管理学院","北京经贸职业学院","北京经济技术职业学院","北京京北职业技术学院","北京交通职业技术学院","北京吉利大学","北京汇佳职业学院","北京工业职业技术学院","北京工商管理专修学院","北京电子科技职业学院","北京财贸职业学院","北京北大方正软件技术学院","北大资源美术学院","北京人文大学","北京高等秘书学院","北京应用技术大学","中国防卫科技学院","中国音乐学院","中国信息大学","北京青年政治学院","北京财经专修学院","北京经济管理职业学院","北京美国英语语言学院","中国管理软件学院","财政部财政科学研究所","北大资源学院","北京现代管理大学","网络销售大学","朝阳二外"]);

dsy.add("0_1",["复旦大学","上海交通大学","同济大学","华东师大","上海财经","华东理工","上海商学院","东华大学","上海理工","上海大学","上外","上海海事","上海工程","上海水产","上海中医药","上海师大","建桥学院","上海政法","上海电机","上海二工大","上海应用技术学院","上海电力","上海外贸","上海金融","上海立信会计学院","上海体院","上海音乐学院","上戏","杉达学院","华东政法大学","上外贤达经济人文学院","同济大学同科学院","上海师范大学天华学院","上海东方文化职业学院","上海工商学院","复旦大学上海视觉艺术学院","复旦大学上海医学院","复旦大学太平洋金融学院","上海邦德职业技术学院","上海诚信学院","上海城市管理职业技术学院","上海出版印刷高等专科学校","上海电影艺术职业学院","上海电子信息职业技术学院","上海东海职业技术学院","上海工会管理职业学院","上海工商外国语学院","上海工艺美术职业学院","上海公安高等专科学校","上海海关学院","上海海事职业技术学院","上海济光职业技术学院","上海建峰职业技术学院","上海交通职业技术学院","上海科学技术职业学院","上海立达职业技术学院","上海旅游高等专科学校","上海民远职业技术学院","上海农林职业技术学院","上海欧华职业技术学院","上海思博职业技术学院","上海托普信息技术学院","上海新侨职业技术学院","上海行健职业学院","上海医疗器械高等专科学校","上海医药高等专科学校","上海震旦职业学院","上海中华职业技术学院","上海中侨职业技术学院","上海纺织工业职工大学"]);

dsy.add("0_2",["南开大学","天津大学","河北工大","天津师大","天津工大","天津科大","天津理工","天津医大","天津中医药","天津财经","中国民航大学","天津城市建设学院","天津农院","天津工程师范","天外","天津商业大学","天津体院","天津音乐学院","天津美院","民办天狮职业技术学院","天津滨海职业技术学院","天津渤海职业技术学院","天津城市建设管理职业技术学院","天津城市职业学院","天津电子信息职业技术学院","天津对外经济贸易职业学院","天津工程职业技术学院","天津工商职业技术学院","天津工业职业技术学院","天津工艺美术职业学院","天津公安警官职业学院","天津海运职业学院","天津机电职业技术学院","天津交通职业学院","天津开发区职业技术学院","天津青年职业学院","天津轻工职业技术学院","天津生物工程职业技术学院","天津石油职业技术学院","天津铁道职业技术学院","天津现代职业技术学院","天津冶金职业技术学院","天津医学高等专科学校","天津艺术职业学院","天津职业大学","天津中德职业技术学院","天津市工会管理干部学院","天津外国语学院滨海外事学院","天津体育学院运动与文化艺术学院","天津商学院宝德学院","天津医科大学临床医学院","北京科技大学天津学院","天津师范大学津沽学院","天津理工大学中环信息学院","天津大学仁爱学院","天津财经大学珠江学院","南开大学滨海学院"]);



dsy.add("0_3",["重庆大学","西南大学","重庆师大","西南政法","重庆交大","重庆邮电大学","重庆医大","重庆工商","重庆科技学院","重庆工学院","长江师范学院","四川外国语","四川美院","重庆三峡学院","重庆文理","重庆巴渝职业技术学院","重庆城市职业学院","重庆电力高等专科学校","重庆电子科技职业学院","重庆电子职业技术学院","重庆工程职业技术学院","重庆工商职业学院","重庆工业职业技术学院","重庆光彩职业技术学院","重庆海联职业技术学院","重庆机电职业技术学院","重庆警官职业学院","重庆民生职业技术学院","重庆三峡医药高等专科学校","重庆三峡职业学院","重庆水利电力职业技术学院","重庆信息技术职业学院","重庆医药高等专科学校","重庆正大软件职业技术学院","重庆职业技术学院","重庆教育学院","重庆应用外国语专修学院","重庆大学城市科技学院","西南大学育才学院","四川外语学院重庆南方翻译学院","重庆师范大学涉外商贸学院","重庆工商大学融智学院","重庆工商大学派斯学院","重庆邮电大学移通学院","重庆工贸职业技术学院","重庆青年职业技术学院","重庆城市管理职业学院"]);

dsy.add("0_4",["哈工大","哈工程","东北林大","东北农大","哈尔滨医科大","黑龙江中医药","黑工程","黑龙江科技大学","哈尔滨学院","哈尔滨体院","东方学院","黑龙江大学","哈尔滨商业大学","哈师大","哈理工","佳木斯大学","齐齐哈尔大学","齐齐哈尔医学院","黑龙江八一农垦大学","大庆石油","大庆师范学院","牡丹江医学院","牡丹江师范","绥化学院","黑河学院","大庆医学高等专科学校","大庆职业学院","大兴安岭职业学院","哈尔滨电力职业技术学院","哈尔滨华夏计算机职业技术学院","哈尔滨金融高等专科学校","哈尔滨铁道职业技术学院","哈尔滨现代公共关系职业学院","哈尔滨职业技术学院","鹤岗师范高等专科学校","黑龙江北开职业技术学院","黑龙江工商职业技术学院","黑龙江公安警官职业学院","黑龙江建筑职业技术学院","黑龙江林业职业技术学院","黑龙江旅游职业技术学院","黑龙江煤炭职业技术学院","黑龙江民族职业学院","黑龙江农垦林业职业技术学院","黑龙江农垦农业职业技术学院","黑龙江农垦职业学院","黑龙江农业工程职业学院","黑龙江农业经济职业学院","黑龙江农业职业技术学院","黑龙江三江美术职业学院","黑龙江商业职业学院","黑龙江生态工程职业学院","黑龙江生物科技职业学院","黑龙江司法警官职业学院","黑龙江信息技术职业学院","黑龙江畜牧兽医职业学院","黑龙江艺术职业学院","鸡西大学","牡丹江大学","七台河职业学院","齐齐哈尔高等师范专科学校","齐齐哈尔职业学院","伊春职业学院","哈尔滨师范大学阿城学院","黑龙江工程学院","黑龙江省政法管理干部学院","黑龙江交通职业技术学院","哈尔滨应用职业技术学院","黑龙江省教育学院","哈尔滨理工大学远东学院","哈尔滨师范大学呼兰学院","哈尔滨师范大学恒星学院","哈尔滨商业大学德强商务学院","大庆石油学院华瑞学院","东北农业大学成栋学院","黑龙江大学剑桥学院","哈尔滨商业大学广厦学院","哈尔滨工业大学华德应用技术学院","鹤岗矿务局职工大学","哈尔滨市职工医学院","佳木斯教育学院","黑龙江幼儿师范高等专科学校","哈尔滨外国语学院"]);


dsy.add("0_5",["吉林大学","东北师范大学","长春大学","吉林农大","长春中医药","东北电力大学","吉林化工","吉林建筑","长春工程学院","长春师范学院","吉林工程师范","吉林华桥外语","长春税务","吉林体院","吉林艺术学院","长春工大","长春理工","延边大学","北华大学","吉林农业科技学院","吉林医药学院","吉林师范","白城师范学院","通化师范","白城医学高等专科学校","长春东方职业学院","长春金融高等专科学校","长春汽车工业高等专科学校","长春信息技术职业学院","长春医学高等专科学校","长春职业技术学院","东北师范大学人文学院","吉林工商学院—财经校区","吉林大学—莱姆顿学院","吉林电子信息职业技术学院","吉林对外经贸职业学院","吉林工业职业技术学院","吉林公安高等专科学校","吉林交通职业技术学院","吉林工商学院—工程校区","吉林农业工程职业技术学院","吉林工商学院—商贸校区","吉林司法警官职业学院","辽源职业技术学院","四平职业大学","松原职业技术学院","吉林省教育学院","吉林经济管理干部学院","长春大学光华学院","长春大学旅游学院","长春工业大学人文信息学院","吉林艺术学院动画学院","长春理工大学光电信息学院","长春税务学院信息经济学院","吉林农业大学发展学院","吉林师范大学博达学院","吉林铁道职业技术学院","白城职业技术学院","吉林建筑工程学院建筑装饰学院","吉林建筑工程学院城建学院"]);

dsy.add("0_6",["大连理工","东北大学","辽宁大学","大连海事","东北财经","大连大学","大连交大","大连医大","辽宁师大","大连民族","大连工大","大连水产","大连外国语学院","辽宁外经贸","沈阳大学","沈阳理工","沈阳工大","沈阳建筑","沈阳农大","辽宁中医药","沈阳药科","沈阳师范","中国刑警学院","沈阳化工","沈阳航空工业学院","沈阳工程","沈阳医学院","沈阳体院","鲁迅美院","沈阳音乐学院","中国医科大","辽宁工大","辽宁石化","鞍山科大","鞍山师范学院","渤海大学","辽宁工业大学","辽宁医学院","辽宁科技学院","辽东学院","鞍山市高等职业专科学校","渤海船舶职业学院","渤海大学文理学院","朝阳师范高等专科学校","大连东软信息学院","大连翻译职业技术学院","大连枫叶职业技术学院","大连软件职业学院","大连商务职业学院","大连艺术职业学院","大连职业技术学院","抚顺师范高等专科学校","抚顺职业技术学院","阜新高等专科学校","锦州商务职业学院","锦州师范高等专科学校","辽宁广播电视大学","辽宁广告职业学院","辽宁机电职业技术学院","辽宁交通高等专科学校","沈阳大学师范学院","辽宁金融职业学院","辽宁经济职业技术学院","辽宁警官高等专科学校","辽宁科技大学","辽宁林业职业技术学院","辽宁美术职业学院","辽宁农业职业技术学院","辽宁商贸职业学院","辽宁石化职业技术学院","大连广播电视大学","辽宁体育运动职业技术学院","辽宁信息职业技术学院","辽阳职业技术学院","盘锦职业技术学院","沈阳航空职业技术学院","沈阳职业技术学院","辽宁职业学院","铁岭师范高等专科学校","营口职业技术学院","沈阳广播电视大学","青岛峻通科技专修学院","辽河石油职业技术学院","青岛广播电视大学","沈阳航空工业学院北方科技学院","沈阳理工大学应用技术学院","大连工业大学艺术与信息工程学院","大连交通大学信息工程学院","沈阳建筑大学城市建设学院","辽宁科技大学信息技术学院","辽宁石油化工大学顺华能源学院","沈阳化工学院科亚学院","沈阳农业大学科学技术学院","中国医科大学临床医药学院","大连医科大学中山学院","辽宁医学院医疗学院","辽宁中医药大学杏林学院","沈阳医学院何氏视觉科学学院","辽宁师范大学海华学院","东北财经大学津桥商学院","沈阳师范大学渤海学院","大连理工大学城市学院","沈阳大学科技工程学院","辽宁装备制造职业技术学院","辽宁文化艺术职工大学","辽宁公安司法管理干部学院","沈阳工业大学工程学院"]);

dsy.add("0_7",["山东大学","中国海洋大学","济南大学","山东建筑大学","山东师大","山东经济学院","山东中医药","山东轻工","山东交通学院","山东警院","山东体院","山东艺术学院","山东工美","曲阜师大","烟台大学","鲁东大学","山东工商","南山学院","青岛大学","山东科大","青岛科大","青岛理工","青岛农业大学","滨海学院","中国石油大学华东","聊城大学","山东理工","潍坊医学院","潍坊学院","泰山医学院","山东财政","泰山学院","山东农大","滨州医学院","滨州学院","济宁医学院","临沂师范","德州学院","枣庄学院","菏泽学院","滨州职业学院","德州教育学院","德州科技职业学院","东营职业学院","哈工大(威海)","菏泽医学专科学校","济南工程职业技术学院","济南铁道职业技术学院","济南职业学院","济宁学院","济宁职业技术学院","莱芜职业技术学院","聊城职业技术学院","青岛飞洋职业技术学院","青岛港湾职业技术学院","青岛恒星职业技术学院","青岛黄海职业学院","青岛求实学院","青岛求实职业技术学院","青岛远洋船员学院","青岛职业技术学院","曲阜远东职业技术学院","日照职业技术学院","山东大王职业学院","山东大学威海分校","山东电力高等专科学校","山东电子职业技术学院","山东纺织职业学院","山东服装职业学院","山东工业职业学院","山东华宇职业技术学院","山东化工职业学院","山东交通职业学院","山东经贸职业学院","山东军星职业技术学院","山东凯文科技职业学院","山东科技职业学院","山东劳动职业技术学院","山东力明科技职业学院","山东旅游职业学院","山东铝业职业学院","山东商业职业技术学院","山东胜利职业学院","山东省青岛酒店管理学院","山东水利职业技术学院","山东省潍坊艺术学校","山东圣翰财贸职业学院","山东水利职业学院","山东水利专科学校","山东丝绸纺织职业学院","山东外国语职业学院","山东外贸职业学院","山东外事翻译学院威海分校","山东外事翻译职业学院","山东万杰医学高等专科学校","山东威海财经专修学院","山东威海外国语进修学院","山东现代职业学院","山东协和职业技术学院","山东信息职业技术学院","山东行政学院(山东经济管理干部学院)","山东杏林科技职业学院","山东畜牧兽医职业学院","山东药品食品职业学院","山东医学高等专科学校","山东英才职业技术学院","山东政法学院","山东中医药高等专科学校","泰山职业技术学院","万杰科技学院","威海市广播电视大学","威海市交通学校","威海职业(技术)学院","威海中加国际工商学院","潍坊工商职业学院","潍坊教育学院","潍坊科技职业学院","潍坊职业学院","文登师范","烟台职业学院","枣庄科技职业学院","中国石油大学(华东)东营校区","淄博广播电视大学","淄博恒星外国语学院","淄博科技职业学院","淄博师专","淄博职业学院","山东省教育学院","山东技师学院","日照广播电视大学","中华女子学院山东分院","山东城市建设职业学院","烟台工程职业技术学院","山东商务职业学院","烟台汽车工程职业学院","山东省农业管理干部学院","山东省青年管理干部学院","山东省工会管理干部学院","山东广播电视大学","德州职业技术学院","中国石油大学胜利学院","烟台大学文经学院","青岛理工大学琴岛学院","山东科技大学泰山科技学院","中国海洋大学青岛学院","山东经济学院燕山学院","青岛农业大学海都学院","曲阜师范大学杏坛学院","山东财政学院东方学院","山东师范大学历山学院","聊城大学东昌学院","济南大学泉城学院","中国农业大学（烟台校区）","日照师范学校","山东艺术设计学院","滨州技术学院","山东省贸易职工大学","山东冶金技术学院","山东省济宁市技术学院","济南广播电视大学"]);

dsy.add("0_8",["山西大学","太原理工","中北大学","山西医大","山西中医学院","太原师范","太原科大","山西财经","山西师大","山西农大","大同大学","长治医学院","长治学院","运城学院","晋中学院","忻州师范","北岳职业技术学院","长治职业技术学院","晋城职业技术学院","晋中职业技术学院","临汾职业技术学院","潞安职业技术学院","吕梁高等专科学校","山西财贸职业技术学院","山西财政税务专科学校","山西电力职业技术学院","山西工程职业技术学院","山西工商职业学院","山西管理职业学院","山西国际商务职业学院","山西华澳商贸职业学院","山西机电职业技术学院","山西建筑职业技术学院","山西交通职业技术学院","山西金融职业技术学院","山西警官高等专科学校","山西警官职业学院","山西林业职业技术学院","山西旅游职业学院","山西煤炭职业技术学院","山西生物应用职业技术学院","山西水利职业技术学院","山西体育职业学院","山西同文外语职业学院","山西戏剧职业学院","山西信息职业技术学院","山西兴华职业学院","山西艺术职业学院","山西运城农业职业技术学院","山西运城学院","山西综合职业技术学院","太原城市职业技术学院","太原大学","太原电力高等专科学校","太原旅游职业学院","忻州职业技术学院","阳泉职业技术学院","山西广播电影电视管理干部学院","山西城市职业技术学院","运城农业学院","山西广播电视大学","晋中学院师范学院","朔州职业技术学院","山西农业大学平遥机电学院","山西农业大学信息学院","山西农业大学太原畜牧兽医学院","山西农业大学太原园艺学院（太原农业学校）","山西农业大学原平农学院（原平农业学校）","太原科技大学运城工学院（运城工学院）","山西财经大学运城学院","山西医科大学汾阳分院","山西医科大学晋祠学院","太原科技大学华科学院","山西财经大学华商学院","中北大学信息商务学院","山西师范大学现代文理学院","忻州师范学院五寨分院（五寨师范学院）","山西大学商务学院","太原工业学院","山西经济管理干部学院"]);

dsy.add("0_9",["西安交大","长安大学","西北工大","西北大学","陕西师大","西安电子科大","西安理工","西安科大","西安工大","西外","西邮","西安医学院","西安财经","西北政法","西安体院","西安美院","西安音乐学院","西安文理学院","西京学院","西安翻译学院","培华学院","欧亚学院","西安外事","西安石油","西安建筑科大","第四军医大学","西安电子科技大学高等职业技术学院","西北工业大学明德学院","陕西师范大学高等职业技术学院","长安大学兴华学院","延安大学","陕西中医学院","咸阳师范学院","陕西科大","宝鸡文理学院","渭南师范","陕西理工","榆林学院","商洛学院","安康学院","西北农林科大","安康职业技术学院","宝鸡职业技术学院","汉中职业技术学院","陕西财经职业技术学院","陕西电子科技职业学院","陕西电子信息职业技术学院","陕西纺织服装职业技术学院","陕西服装艺术职业学院","陕西工业职业技术学院","陕西国防工业职业技术学院","陕西国际商贸职业学院","陕西航空职业技术学院","陕西交通职业技术学院","陕西经济管理职业技术学院","陕西警官职业学院","陕西旅游烹饪职业学院","陕西能源职业技术学院","陕西青年职业学院","陕西铁路工程职业技术学院","陕西邮电职业技术学院","陕西职业技术学院","商洛职业技术学院","铜川职业技术学院","渭南职业技术学院","西安电力高等专科学校","西安东方亚太职业技术学院","西安高新科技职业学院","西安工程大学","西安海棠职业学院","西安航空技术高等专科学校","西安航空职业技术学院","西安科技商贸职业学院","西安汽车科技职业学院","西安三资职业学院","西安思源学院","西安铁路职业技术学院","西安职业技术学院","咸阳职业技术学院","延安职业技术学院","杨凌职业技术学院","陕西银行学校","西安机电信息技术学院","陕西教育学院","陕西省旅游学校","西安铁路工程职工大学","西安华西专修大学","西安航空职工大学","西安建筑科技大学华清学院","西安财经学院行知学院","陕西科技大学镐京学院","西安工业大学北方信息工程学院","延安大学西安创新学院","西安电子科技大学长安学院","西安理工大学高科学院","西安科技大学高新学院","西安交通大学城市学院","西北大学现代学院"]);

dsy.add("0_10",["河北大学","河北农大","中央司法警官学院","石家庄铁院","石家庄经院","河北师大","河北科技","河北医科","河北经贸","河北体院","石家庄学院","燕山大学","河北科师","河北理工","华北煤炭医学","唐山学院","唐山师范","华北航工","廊坊师范","防灾科技学院","华北科技","河北建工","北方学院","承德医学院","邢台学院","河北工程","邯郸学院","衡水学院","保定电力职业技术学院","保定科技职业学院","河北金融学院","保定学院","保定职业技术学院","渤海石油职业学院","沧州师范专科学校","沧州医学高等专科学校","沧州职业技术学院","河北旅游职业学院","承德民族师范高等专科学校","承德石油高等专科学校","大庆石油学院秦皇岛分院","东北大学秦皇岛校区","邯郸职业技术学院","河北大学医学部","河北工程技术高等专科学校","河北工业职业技术学院","河北公安警察职业学院","河北化工医药职业技术学院","河北机电职业技术学院","河北建材职业技术学院","河北交通职业技术学院","河北京都高尔夫职业学院","河北农业大学","河北农业大学海洋学院","河北女子职业技术学院","河北软件职业技术学院","河北省艺术职业学院","河北石油职业技术学院","河北司法警官职业学院","河北通信职业技术学院","河北远东职业技术学院","河北政法管理干部学院","河北职业技术学院","衡水职业技术学院","华北电力大学(保定)","监督管理局","廊坊大学城北大方正软件学院","廊坊东方大学城北京澳际联邦英语学校","廊坊东方大学城北京财经学院","廊坊东方大学城北京城市学院","廊坊东方大学城北京传媒学院","廊坊东方大学城北京经济技术职业学院","廊坊东方大学城北京经贸职业学院航空服务学院","廊坊东方大学城北京联合大学","廊坊东方大学城北京中医药大学中专部","廊坊东方大学城河北体育学院","廊坊东方大学城廊坊职业技术学院","秦皇岛教育学院","秦皇岛外国语职业学院","秦皇岛职业技术学院","石家庄东方美术职业学院","石家庄法商职业学院","石家庄工商职业学院","石家庄计算机职业学院","石家庄科技信息职业学院","石家庄联合技术职业学院","石家庄铁路职业技术学院","石家庄外国语职业学院","石家庄外经贸职业学院","石家庄外语翻译职业学院","石家庄信息工程职业学院","石家庄医学高等专科学校","河北传媒学院","石家庄邮电职业技术学院","石家庄职业技术学院","唐山工业职业技术学院","唐山广播电视大学","唐山科技职业技术学院","唐山职业技术学院","邢台医学高等专科学校","邢台职业技术学院","张家口职业技术学院","中国地质大学长城学院","中国环境管理干部学院","中国民航管理干部学院","张家口教育学院","河北能源职业技术学院","承德卫生学校","邯郸中原外国语职业学院","河北师范大学汇华学院","华北煤炭医学院冀唐学院","河北医科大学临床学院","河北农业大学现代科技学院","石家庄铁道学院四方学院","燕山大学里仁学院","河北工程大学科信学院","河北理工大学轻工学院","河北大学工商学院","河北经贸大学经济管理学院"]);

dsy.add("0_11",["郑州大学","河南工业","河南农大","华北水利水电","郑州轻工","郑州航空工业","黄河科技","中原工学院","河南中医学院","河南财经","河南大学","河南科技大学","洛阳师院","安阳工学院","安阳师院","南阳理工","南阳师院","平顶山工学院","平顶山学院","新乡医学院","河南科技学院","河南师大","信阳师院","商丘师院","周口师院","黄淮学院","许昌学院","河南理工","河南财政税务高等专科学校","河南工程学院","河南工业贸易职业学院","河南工业职业技术学院","河南公安高等专科学校","河南广播影视学院","河南机电高等专科学校","河南检察职业学院","河南交通职业技术学院","河南教育学院","河南经贸职业学院","河南农业职业学院","河南商业高等专科学校","河南省工商行政管理广播电视大学","河南省政法管理干部学院","河南司法警官职业学院","河南新华电脑学院","河南职业技术学院","河南质量工程职业学院","鹤壁职业技术学院","黄河水利职业技术学院","济源职业技术学院","焦作大学","焦作师范高等专科学校","开封大学","开封市电子科技专修学校","洛阳大学","洛阳理工学院","漯河医学高等专科学校","漯河职业技术学院","南阳医学高等专科学校","平顶山教育学院","平顶山职业技术学院","平原大学","濮阳职业技术学院","三门峡职业技术学院","商丘科技职业学院","商丘医学高等专科学校","商丘职业技术学院","嵩山少林武术职业学院","铁道警官高等专科学校","新乡师范高等专科学校","新乡市教育学院","信阳农业高等专科学校","信阳职业技术学院","许昌职业技术学院","永城职业学院","郑州大学西亚斯国际学院","郑州电力高等专科学校","郑州电子信息职业技术学院","郑州工业安全职业学院","郑州华信职业技术学院","郑州交通学院","郑州经贸职业学院","郑州科技职业学院","郑州旅游职业学院","郑州牧业工程高等专科学校","郑州师范高等专科学校","郑州澍青医学高等专科学校","郑州铁路职业技术学院","郑州信息科技职业学院","郑州职业技术学院","中州大学","周口职业技术学院","郑州大学升达经贸管理学院","河南建筑职工大学","洛阳工业高等专科学校","河南职工医学院","河南科技学院新科学院","河南理工大学万方科技学院","中原工学院信息商务学院","安阳师范学院人文管理学院","河南农业大学华豫学院","河南财经学院成功学院","开封教育学院","河南政法管理干部学院","河南卫生职工学院","河南省建筑职工大学","河南大学民生学院","河南师范大学新联学院","新乡医学院三全学院","信阳师范学院华锐学院"]);

dsy.add("0_12",["武汉大学","华中科大","华中农大","武汉理工","中国地质大学（武汉）","中南财经政法","中南民族大学","华中师大","武汉工业学院","武汉科技学院","湖北中医学院","湖北经济学院","湖北警官学院","武汉体院","湖北美院","武汉音乐学院","武汉生物工程学院","湖北工大","湖北大学","江汉大学","武汉工大","武汉科大","长江大学","三峡大学","湖北汽院","郧阳医学院","孝感学院","湖北师范学院","黄石理工","黄冈师院","湖北民族学院","襄樊学院","咸宁学院","长江工程职业技术学院","长江职业学院","鄂东职业技术学院","鄂州大学","恩施职业技术学院","湖北财经高等专科学校","湖北财税职业学院","湖北城市建设职业技术学院","湖北工业大学商贸学院","湖北国土资源职业学院","湖北黄石机电职业技术学院","湖北交通职业技术学院","湖北第二师范学院","湖北经济管理干部学院","湖北开放职业学院","湖北民族学院科技学院","湖北轻工职业技术学院","湖北三峡职业技术学院","湖北生态工程职业技术学院","湖北生物科技职业学院","湖北省水利水电职业技术学院","湖北师范学院文理学院","湖北艺术职业学院","湖北职业技术学院","湖北中医药高等专科学校","黄冈科技职业学院","黄冈职业技术学院","江汉艺术职业学院","荆楚理工学院","荆州职业技术学院","沙市职业大学","沙洋师范高等专科学校","十堰职业技术学院","随州职业技术学院","武汉船舶职业技术学院","武汉电力职业技术学院","武汉工程职业技术学院","武汉工业职业技术学院","武汉航海职业技术学院","武汉交通职业学院","武汉警官职业学院","武汉科技职业学院","武汉理工大学华夏学院","武汉民政职业学院","武汉软件工程职业学院","武汉商贸学院","武汉商业服务学院","武汉时代职业学院","武汉铁路职业技术学院","武汉外语外事职业学院","武汉信息传播职业技术学院","武汉职业技术学院","仙桃职业学院","咸宁职业技术学院","襄樊职业技术学院","孝感学院新技术学院","郧阳师范高等专科学校","中南民族大学工商学院","黄冈广播电视大学","华中科技大学文华学院","华中师范大学汉口分校","湖北大学知行学院","三峡大学科技学院","武汉科技大学中南分校","湖北工业大学工程技术学院","武汉工业学院工商学院","武汉工程大学邮电与信息工程学院　","武汉科技学院外经贸学院","江汉大学文理学院","湖北汽车工业学院科技学院","湖北经济学院法商学院　","武汉体育学院体育科技学院","郧阳医学院药护学院","襄樊学院理工学院","中国地质大学江城学院","长江大学文理学院","长江大学工程技术学院","华中师范大学武汉影视工程学院","武汉大学东湖分校","中南财经政法武汉学院","华中科技大学武昌分校"]);

dsy.add("0_13",["湖南师大","中南大学","湖南大学","长沙理工","湖南农大","湖南中医药","中南林业科大","长沙学院","长沙医学院","湖南涉外经济","湖南商学院","湖南人文科技","湘潭大学","湖南科大","湖南工程学院","南华大学","吉首大学","湖南工大","湖南城市","湖南理工学院","湘南学院","衡阳师院","湖南文理","怀化学院","湖南科技学院","邵阳学院","保险职业学院","长沙电力职业技术学院","长沙航空职业学院","长沙环境保护职业技术学院","长沙民政职业技术学院","长沙南方职业学院","长沙商贸旅游职业技术学院","长沙师范专科学校","长沙通信职业技术学院","长沙职工大学","长沙职业技术学院","常德职业技术学院","郴州职业技术学院","衡阳财经工业职业技术学院","湖南安全技术职业学院","湖南财经高等专科学校","湖南城建职业技术学院","湖南大众传媒学院","湖南第一师范","湖南对外经济贸易职业学院","湖南工程职业技术学院","湖南工学院","湖南工业职业技术学院","湖南工艺美术职业学院","湖南公安高等专科学校","湖南广播电视大学","湖南化工职业技术学院","湖南环境生物职业技术学院","湖南机电职业技术学院","湖南建材高等专科学校","湖南交通工程职业技术学院","湖南交通职业技术学院","湖南经济干部管理学院","湖南九嶷职业技术学院","湖南科技经贸职业学院","湖南科技职业技术学院","湖南理工职业技术学院","湖南娄底远东职业学校","湖南民族职业学院","湖南农业大学国际学院","湖南女子大学","湖南软件职业技术学院","湖南商务职业技术学院","湖南生物环境职业技术学院","湖南生物机电职业技术学院","湖南省水利水电职业技术学院","湖南石油化工职业技术学院","湖南税务高等专科学校","湖南司法警官职业技术学院","湖南体育职业学院","湖南铁道职业技术学院","湖南铁路科技职业技术学院","湖南同德职业学院","湖南网络工程职业学院","湖南现代物流职业技术学院","湖南信息科学职业学院","湖南信息职业技术学院","湖南行政学院","湖南冶金职业技术学院","湖南艺术职业学院","湖南中医药高等专科学校","怀化医学高等专科学校","怀化职业技术学院","娄底理工学院","娄底市卫生学校","娄底职业技术学院","邵阳医学高等专科学校","邵阳职业技术学院","湘潭职业技术学院","湘西民族职业技术学院","潇湘职业学院","益阳职业技术学院","永州职业技术学院","岳阳职业技术学院","张家界航空工业职业技术学院","株洲师范高等专科学校","株洲职业技术学院","湘潭大学兴湘学院","湖南工业大学科技学院","湖南科技大学潇湘学院","南华大学船山学院","湖南商学院北津学院","湖南师范大学树达学院","湖南农业大学东方科技学院","中南林业科技大学涉外学院","湖南文理学院芙蓉学院","湖南理工学院南湖学院","衡阳师范学院南岳学院","湖南工程学院应用技术学院","湖南中医药大学湘杏学院","吉首大学张家界学院","长沙理工大学城南学院","湖南都市职业学院","湖南电子科技职业学院","湖南外国语职业学院"]);

dsy.add("0_14",["海南大学","海南医学院","海南师范大学","华南热带农大","琼州大学","海口经济职业技术学院","海南经贸职业技术学院","海南软件职业技术学院","海南外国语职业学院","海南万和信息职业技术学院","海南政法职业学院","海南职业技术学院","琼台师范高等专科学校","三亚航空旅游职业学院","三亚卓达旅游职业学院","海南大学三亚学院"]);

dsy.add("0_15",["南京大学","河海大学","南京师大","南京理工","东南大学","南航","南京财经","南京医科大","南京工大","南京农大","南京林大","南邮","南京信息工程大学","南京中医药","南京工程","金陵科技学院","晓庄学院","南京审计学院","江苏警官学院","南京体院","南京艺术学院","三江学院","中国药科大","苏州大学","江南大学","中国矿大（徐州）","徐州师大","徐州工程","徐州医学院","扬州大学","江苏大学","江苏科大","南通大学","江苏工业","常州工学院","江苏技术师范","淮阴工学院","淮阴师范","淮海工学院","盐城工学院","盐城师范学院","常熟理工","常州纺织服装职业技术学院","常州工程职业技术学院","常州机电职业技术学院","常州轻工职业技术学院","常州信息职业技术学院","硅湖职业技术学院","河海大学常州校区","淮安信息职业技术学院","建东职业技术学院","健雄职业技术学院","江海职业技术学院","江南影视艺术职业学院","江苏财经职业技术学院","江苏海事职业技术学院","江苏经贸职业技术学院","江苏联合职业技术学院","江苏农林职业技术学院","江苏食品职业技术学院","江苏信息职业技术学院","江苏畜牧兽医职业技术学院","江阴职业技术学院","金肯职业技术学院","金山职业技术学院","九州职业技术学院","昆山登云科技职业学院","连云港师范高等专科学校","连云港职业技术学院","民办明达职业技术学院","南京动力高等专科学校","南京工业职业技术学院","南京化工职业技术学院","南京交通职业技术学院","南京人口管理干部学院","南京森林公安高等专科学校","南京视觉艺术职业学院","南京特殊教育职业技术学院","南京铁道职业技术学院","南京信息职业技术学院","南通纺织职业技术学院","南通航运职业技术学院","南通农业职业技术学院","南通职业大学","培尔职业技术学院","沙洲职业工学院","苏州港大思培科技职业学院","苏州工业园区职业技术学院","苏州工业职业技术学院","苏州工艺美术职业技术学院","苏州经贸职业技术学院","苏州科技大学","苏州农业职业技术学院","苏州托普信息职业技术学院","苏州职业大学","宿迁学院","泰州师范高等专科学校","泰州职业技术学院","无锡城市职业技术学院","无锡工艺职业技术学院","无锡科技职业学院","无锡南洋职业技术学院","无锡轻工大学","无锡商业职业技术学院","无锡职业技术学院","徐州工业职业技术学院","徐州广播电视大学","徐州建筑职业技术学院","徐州教育学院","徐州工程学院","炎黄职业技术学院","盐城纺织职业技术学院","扬州工业职业技术学院","扬州环境资源管理学院","扬州环境资源职业技术学院","扬州教育学院","扬州职业大学","应天职业技术学院","镇江市高等专科学校","正德职业技术学院","中国传媒大学南广学院","钟山职业技术学院","紫琅职业技术学院","江苏广播电视大学","江苏教育学院","徐州师范高等专科学校","江苏省省级机关管理干部学院","江苏职工医科大学","苏州卫生职业技术学院","盐城卫生职业技术学院","金陵旅馆管理干部学院","南京市广播电视大学"]);

dsy.add("0_16",["江西财经","南昌大学","华东交通大学","南昌航空大学","南昌工程","南昌理工","江西中医学院","江西科技师范学院","蓝天学院","江西农大","江西师大","东华理工大学","景德镇陶瓷学院","赣南医学院","赣南师范学院","江西理工","上饶师范学院"]);

dsy.add("0_17",["华南理工大学","中山大学","暨南大学","华南师范大学","广东工业大学","华南农业大学","广州大学","广东外语外贸大学","广州中医药大学","南方医科大学","仲恺农业技术学院","广州医学院","广东药学院","广东金融学院","广东商学院","广东警官学院","广州体育学院","广州美术学院","星海音乐学院","广东技术师范学院","广东培正学院"]);

dsy.add("0_18",["广西大学","广西医科大学","广西民族大学","广西中医学院","广西师范学院","广西财经学院","广西艺术学院","桂林电子科技大学","广西师范大学","桂林工学院","桂林医学院","广西工学院","右江民族医学院","百色学院","河池学院","玉林师范学院","钦州学院","贺州学院","梧州学院","广西大学行健文理学院","广西师范大学漓江学院"]);

dsy.add("0_19",["昆明理工","云南农大","云南师大","云南财经","云南民大","西南林学院","昆明医学院","云南中医学院","红河学院","云南警官学院","云南艺术","云南大学","曲靖师范","玉溪师院","楚雄师院","大理学院","保山师范高等专科学校","保山中医药高等专科学校","楚雄医药高等专科学校","德宏师范高等专科学校"]);

dsy.add("0_20",["贵州大学","贵阳医学院","贵阳中医学院","贵州财经","贵州民族","贵阳学院","贵州师大","铜仁学院","遵义医学院","遵义师范","毕节学院","黔南师院","安顺学院","凯里学院","安顺职业技术学院","贵州电力职业技术学院"]);

dsy.add("0_21",["四川大学","四川农大","电子科大","西南交大","成都理工","四川师大","西南民族大学","成都大学","西南财经","西华大学","成都中医药","成都信息工程大学","成都医学院","四川文理学院","成都体院","四川音乐学院","西南石油","中国民航飞行学院","四川理工","泸州医学院","四川警察学院","川北医学院","西华师大","内江师范","乐山师院","绵阳师范","西南科大","西昌学院","宜宾学院","攀枝花学院","阿坝师范高等专科学校","成都电子机械高等专科学校","成都东软信息技术职业学院"]);

dsy.add("0_22",["内蒙古大学","内蒙古工业大学","内蒙古农大","内蒙古师大","内蒙古医学院","内蒙古财经","内蒙古科大","内蒙古民族大学","赤峰学院","呼伦贝尔学院","包头钢铁职业技术学院","包头轻工职业技术学院","包头职业技术学院","河套大学","呼和浩特职业学院","集宁师范高等专科学校","科尔沁艺术职业学院","内蒙古财税职业学院","内蒙古电子信息职业技术学院","内蒙古青城大学","内蒙古化工职业学院","内蒙古机电职业技术学院","内蒙古建筑职业技术学院","内蒙古交通职业技术学院","内蒙古民族高等专科学校","内蒙古商贸职业学院","内蒙古体育职业学院","通辽职业学院","乌海职业技术学院","乌兰察布职业学院","锡林郭勒职业学院","兴安职业技术学院","内蒙古警察职业学院","内蒙古北方职业技术学院","内蒙古丰州学院","内蒙古经贸外语职业学院","内蒙古科技职业学院","赤峰职业技术学院"]);

dsy.add("0_23",["宁夏大学","北方民大","宁夏医学院","宁夏理工","宁夏师范","吴忠职业技术学院","宁夏职业技术学院","宁夏财经职业技术学院","宁夏司法警官职业学院","宁夏师范学院","宁夏工业职业学院","宁夏经贸职业技术学院","宁夏建设职业技术学院","银川科技职业学院","宁夏大学新华学院"]);

dsy.add("0_24",["兰州大学","西北民大","西北师大","甘肃中医学院","兰州商院","甘肃政法学院","兰州城市学院","甘肃农大","兰州理工","兰州交大","天水师院","陇东学院","河西学院","兰州石化职业技术学院","甘肃工业职业技术学院","甘肃警察职业学院","兰州理工大学技术工程学院","兰州职业技术学院","武威职业学院"]);

dsy.add("0_25",["青海大学","青海师大","青海民院","青海民族师范高等专科学校","青海财经职业学院","青海畜牧兽医职业技术学院","青海建筑职业技术学院","青海师范高等专科学校","青海警官职业学院","青海交通职业技术学院","青海卫生职业技术学院"]);

dsy.add("0_26",["西藏大学","西藏藏医学院","西藏民院","拉萨师范高等专科学校","西藏警官高等专科学校","西藏职业技术学院"]);

dsy.add("0_27",["新疆大学","新疆农大","新疆医科大","新疆师大","新疆财经","新疆艺术学院","石河子大学","塔里木大学","喀什师院","伊犁师院","昌吉学院","阿克苏职业技术学院","巴音郭楞职业技术学院","昌吉职业技术学院","和田师范专科学校","克拉玛依职业技术学院","乌鲁木齐职业大学","新疆兵团警官高等专科学校","新疆工业高等专科学校","新疆机电职业技术学院","新疆建设职业技术学院","新疆交通职业技术学院","新疆警官高等专科学校","新疆能源职业技术学院","新疆农业职业技术学院","新疆轻工职业技术学院","新疆石河子职业技术学院","新疆天山职业技术学院","新疆维吾尔医学专科学校","新疆现代职业技术学院","伊犁职业技术学院","新疆科信学院","新疆职业大学","新疆石油学院","新疆大学科学技术学院","新疆农业大学科学技术学院","新疆财经大学商务学院","新疆医科大学厚博学院","石河子大学科技学院"]);

dsy.add("0_28",["中国科大","安徽大学","合肥工大","安徽医科大","安徽建工","安徽中医","合肥学院","安徽农大","安徽工业大学","安徽科技","皖南医学院","安徽师大","安徽工程科技","蚌埠医学院","安徽财经","阜阳师范","淮南师范","安徽理工","淮北煤炭师范","安庆师范","铜陵学院","皖西学院","巢湖学院","滁州学院","宿州学院","黄山学院","新华学院","蚌埠学院","安徽财贸职业学院","安徽城市管理职业学院"]);

dsy.add("0_29",["浙江大学","浙江理工","浙江工大","杭州电子科大","浙江中医药","浙江工商","中国计量","浙江科技","浙江林院","杭州师范","浙江传媒","浙江财经","中国美术学院","树人大学","宁波大学","宁波工程","万里学院","诺丁汉大学","嘉兴学院","浙江海洋","温州大学","温州医学院","湖州师范","台州学院","绍兴文理学院","丽水学院","浙江师大","长征职业技术学院","公安海警高等专科学校","杭州万向职业技术学院","杭州职业技术学院","湖州职业技术学院"]);
dsy.add("0_30",["厦门大学","集美大学","厦门理工学院","福州大学","福建师范大学","福建农林大学","福建医科大学","福建工程学院","福建中医学院","闽江学院","华侨大学","仰恩大学","泉州师范学院","漳州师范","莆田学院","三明学院","龙岩学院","厦门大学嘉庚学院","集美大学诚毅学院","福州大学阳光学院","福州大学至诚学院","福建师范大学协和学院","福建师范大学闽南科技学院","福建农林大学东方学院","福建农林大学金山学院","华侨大学福建音乐学院","福建电力职业技术学院","福建对外经济贸易职业技术学院","福建警察学院","福建广播电视大学","福建华南女子职业学院","福建交通职业技术学院","福建教育学院","福建金融职业技术学院","福建警官职业学院","福建林业职业技术学院","福建农业职业技术学院","福建商业高等专科学校"]);
dsy.add("0_31",["国立台湾大学","国立中正大学","国立台湾艺术大学","国立清华大学","国立中山大学","国立政治大学","国立成功大学","国立中央大学","国立阳明大学","国立东华大学","国立中兴大学","国立台湾师范大学","国立台湾海洋大学","国立高雄大学","国立嘉义大学","国立台湾科技大学","国立空中大学","国立台北大学","国立高雄师范大学","国立联合大学","国立暨南国际大学","国立屏东科技大学","国立彰化师范大学","国立台北科技大学","国立台东大学","国立宜蓝大学","国立台北艺术大学","国立云林科技大学","国立台南大学","国立虎尾科技大学","国立花莲教育大学","国立高雄第一科技大学","国立屏东教育大学","国立新竹教育大学","国立澎湖科技大学","建国科技大学","国立台南艺术大学","国立高雄应用科技大学"]);

dsy.add("0_32",["香港大学","香港中文大学","香港科技大学","香港理工大学","香港城市大学","香港浸会大学","香港岭南大学"]);
dsy.add("0_33",["澳门大学","澳门理工学院","澳门科技大学","澳门旅游学院","澳门镜湖护理学院","澳门国际公开大学"]);
dsy.add("0",["北京","上海","天津","重庆","黑龙江","吉林","辽宁","山东","山西","陕西","河北","河南","湖北","湖南","海南","江苏","江西","广东","广西","云南","贵州","四川","内蒙古","宁夏","甘肃","青海","西藏","新疆","安徽","浙江","福建","台湾","香港","澳门"]);

var s=["s_province","www"];//三个select的name
var opt0 = ["省份","学校"];//初始值
function _init_area(){  //初始化函数
	for(i=0;i<s.length-1;i++){
	  document.getElementById(s[i]).onchange=new Function("change("+(i+1)+")");
	}
	change(0);
}

/* 代码整理：懒人之家 www.lanrenzhijia.com */