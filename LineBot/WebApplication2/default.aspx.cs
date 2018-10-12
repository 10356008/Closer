using isRock.LineBot;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication2
{
    public partial class _default : System.Web.UI.Page
    {
        const string channelAccessToken = "BXFOUD+4p4GuBzEly7y4O2khG8qmxaBttbQwV+4qjYcOTAVIO4nKM+MvQCt8YbYFuY3G/vdPeKhW55wLX4ucuTAjlZwHTyhf9PfCZDbmXW8R1FLYhMBARftvIZ/ao3mInNlusj4zwtvSCAvNcJdsIAdB04t89/1O/w1cDnyilFU=";
        const string AdminUserId= "U04fcc2c004642a37234aa6767448b58c";

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            var bot = new Bot(channelAccessToken);
            bot.PushMessage(AdminUserId, $"測試 {DateTime.Now.ToString()} ! ");
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            var bot = new Bot(channelAccessToken);
            bot.PushMessage(AdminUserId, 1,2);
        }
    }
}