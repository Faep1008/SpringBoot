/**
 *
 * @description
 */
function htmlRender(template, data){
    addCondition(template, data);
    return Mustache.to_html.apply(this, arguments);
}
function addCondition(template, data){
    var conditions = getCondition(template);
    var key = "";
    for (var i = 0; i < conditions.length; i++) {
        key = "if(" + conditions[i] + ")";
        if (data[key]) {
            continue;
        }
        else {
            data[key] = buildCondition(conditions[i]);
        }
    }
}
function getCondition(template){
    var condition1 = /\{{2,3}[\^#]?if\((.*?)\)\}{2,3}?/ig;
    var condition2 =  /\{{2,3}[\^#]?if\((.*?)\)\}{2,3}?/i;
    var accord = template.match(condition1);
    var ret = [];
    if (accord) {
        for (var i = 0; i < accord.length; i++) {
            ret.push(accord[i].match(condition2)[1]);
        }
    }
    return ret;
}
function buildCondition(condition){
    condition = condition.split("==");
    var ret = function(){
        var constant = condition[0].split("."), value = condition[1];
        var data = this;
        for (var i = constant.length - 1; i > -1; i--) {
            var fixed = constant.slice(i);
            var d = data;
            try {
                for (var j = 0; j < fixed.length - 1; j++) {
                    d = d[fixed[j]];
                }
                if (fixed[fixed.length - 1] in d) {
                    if (d[fixed[fixed.length - 1]].toString() === value) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
            catch (err) {
            }
        }
        return false;
    };
    return ret;
}

