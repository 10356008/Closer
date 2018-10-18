using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace StudyHostExampleLinebot.Controllers
{
    public class TestQnAController : isRock.LineBot.LineWebHookControllerBase
    {
        const string channelAccessToken = "BXFOUD+4p4GuBzEly7y4O2khG8qmxaBttbQwV+4qjYcOTAVIO4nKM+MvQCt8YbYFuY3G/vdPeKhW55wLX4ucuTAjlZwHTyhf9PfCZDbmXW8R1FLYhMBARftvIZ/ao3mInNlusj4zwtvSCAvNcJdsIAdB04t89/1O/w1cDnyilFU=";
        const string AdminUserId = "U04fcc2c004642a37234aa6767448b58c";
        const string QnAKey = "ca1a0dd2-c0aa-40b3-a810-168533df7efe";
        const string Endpoint = "https://closertest.azurewebsites.net/qnamaker/knowledgebases/3e70ac97-c64a-4881-9811-83dfa3bc1615/generateAnswer";
        const string UnknowAnswer = "不好意思，您可以換個方式問嗎? 我不太明白您的意思...";

        [Route("api/TestQnA")]
        [HttpPost]
        public IHttpActionResult POST()
        {
            try
            {
                //設定ChannelAccessToken(或抓取Web.Config)
                this.ChannelAccessToken = channelAccessToken;
                //取得Line Event(範例，只取第一個)
                var LineEvent = this.ReceivedMessage.events.FirstOrDefault();
                //配合Line verify 
                if (LineEvent.replyToken == "00000000000000000000000000000000") return Ok();
                //回覆訊息
                if (LineEvent.type == "message")
                {
                    var reply = "";
                    reply = LineEvent.message.text;

                    if (LineEvent.message.type == "text") //收到文字
                    {
                        if(reply == "嗨" || reply == "你好" || reply == "妳好" || reply == "哈囉" || reply == "哈摟" || reply == "哈嘍" || reply == "Hello" || reply == "Hi" || reply == "HELLO" || reply == "HI" || reply == "hello" || reply == "hi")
                        {
                            //建立actions，作為ButtonTemplate的用戶回覆行為
                            var actions = new List<isRock.LineBot.TemplateActionBase>();
                            actions.Add(new isRock.LineBot.PostbackActon() { label = "開始聊天", data = "有什麼社交上的困擾嗎?" });
                            actions.Add(new isRock.LineBot.UriActon() { label = "瀏覽學習頁面", uri = new Uri("http://140.131.114.147/detailsView") });


                            var ButtonTemplateMsg = new isRock.LineBot.ButtonsTemplate()
                            {
                                title = "嗨!",
                                text = "請問您要:",
                                altText = "嗨 ButtonTemplate",
                                actions = actions
                            };
                            this.PushMessage(LineEvent.source.userId, ButtonTemplateMsg);
                        }
                        else if (reply == "使用說明")
                        {
                            //建立actions，作為ButtonTemplate的用戶回覆行為
                            var actions = new List<isRock.LineBot.TemplateActionBase>();
                            actions.Add(new isRock.LineBot.PostbackActon() { label = "開始聊天", data = "有什麼社交上的困擾嗎?" });
                            actions.Add(new isRock.LineBot.UriActon() { label = "瀏覽學習頁面", uri = new Uri("http://140.131.114.147/detailsView") });


                            var ButtonTemplateMsg = new isRock.LineBot.ButtonsTemplate()
                            {
                                title = "使用說明",
                                text = "我們可以針對您在校園社交上的問題進行解惑(ex:要和新同學聊什麼?)，或是可以瀏覽我們的學習頁面網站。",
                                altText = "使用說明 ButtonTemplate",
                                actions = actions
                            };
                            this.PushMessage(LineEvent.source.userId, ButtonTemplateMsg);
                        }
                        else if (reply == "關於我們")
                        {

                            //建立actions，作為ButtonTemplate的用戶回覆行為
                            var actions = new List<isRock.LineBot.TemplateActionBase>();
                            actions.Add(new isRock.LineBot.UriActon() { label = "查看更多", uri = new Uri("http://140.131.114.147/about") });

                            var ButtonTemplateMsg = new isRock.LineBot.ButtonsTemplate()
                            {
                                title = "關於我們",
                                text = "您好，我們是國立臺北商業大學 資訊管理系的學生。",
                                altText = "使用說明 ButtonTemplate",
                                actions = actions
                            };
                            this.PushMessage(LineEvent.source.userId, ButtonTemplateMsg);

                        }
                        else if (reply == "學習頁面")
                        {
                            var flex = @"
                                [
                                {
                                    ""type"": ""flex"",
                                    ""altText"": ""Closer | Learn Web"",
                                    ""contents"":
                                {
                                  ""type"": ""bubble"",
                                  ""header"": {
                                                ""type"": ""box"",
                                    ""layout"": ""horizontal"",
                                    ""contents"": [
                                      {
                                        ""type"": ""text"",
                                        ""text"": ""學習頁面"",
                                        ""weight"": ""bold"",
                                        ""color"": ""#aaaaaa"",
                                        ""size"": ""sm""
                                      }
                                    ]
                                  },
                                  ""hero"": {
                                    ""type"": ""image"",
                                    ""url"": ""https://imageshack.com/a/img924/8986/kuGMSb.png"",
                                    ""size"": ""full"",
                                    ""aspectRatio"": ""20:13"",
                                    ""aspectMode"": ""cover""
                                  },
                                  ""body"": {
                                    ""type"": ""box"",
                                    ""layout"": ""horizontal"",
                                    ""spacing"": ""md"",
                                    ""contents"": [
                                      {
                                        ""type"": ""box"",
                                        ""layout"": ""vertical"",
                                        ""flex"": 1,
                                        ""contents"": [
                                          {
                                            ""type"": ""image"",
                                            ""url"": ""https://imageshack.com/a/img922/3247/oaCfJg.jpg"",
                                            ""aspectMode"": ""cover"",
                                            ""aspectRatio"": ""4:3"",
                                            ""size"": ""sm"",
                                            ""gravity"": ""bottom""
                                          },
                                          {
                                            ""type"": ""image"",
                                            ""url"": ""https://imageshack.com/a/img922/4655/RrcctW.jpg"",
                                            ""aspectMode"": ""cover"",
                                            ""aspectRatio"": ""4:3"",
                                            ""margin"": ""md"",
                                            ""size"": ""sm""
                                          }
                                        ]
                                      },
                                      {
                                        ""type"": ""box"",
                                        ""layout"": ""vertical"",
                                        ""flex"": 2,
                                        ""contents"": [
                                          {
                                            ""type"": ""text"",
                                            ""text"": ""你的敵人，可能就是你的救星。"",
                                            ""gravity"": ""top"",
                                            ""size"": ""xs"",
                                            ""flex"": 1
                                          },
                                          {
                                            ""type"": ""separator""
                                          },
                                          {
                                            ""type"": ""text"",
                                            ""text"": ""完美溝通術:技巧大有學問的9項對話技巧"",
                                            ""gravity"": ""center"",
                                            ""size"": ""xs"",
                                            ""flex"": 2
                                          },
                                          {
                                            ""type"": ""separator""
                                          },
                                          {
                                            ""type"": ""text"",
                                            ""text"": ""你是腦補王嗎？小心變成偏執狂"",
                                            ""gravity"": ""center"",
                                            ""size"": ""xs"",
                                            ""flex"": 2
                                          },
                                          {
                                            ""type"": ""separator""
                                          },
                                          {
                                            ""type"": ""text"",
                                            ""text"": ""你是團體中的絆腳石嗎？"",
                                            ""gravity"": ""bottom"",
                                            ""size"": ""xs"",
                                            ""flex"": 1
                                          }
                                        ]
                                      }
                                    ]
                                  },
                                  ""footer"": {
                                    ""type"": ""box"",
                                    ""layout"": ""horizontal"",
                                    ""contents"": [
                                      {
                                        ""type"": ""button"",
                                        ""action"": {
                                          ""type"": ""uri"",
                                          ""label"": ""更多內容"",
                                          ""uri"": ""http://140.131.114.147""
                                        }
                                      }
                                    ]
                                  }
                                }
                                }
                                ]
                                ";


                            this.PushMessagesWithJSON(LineEvent.source.userId, flex);
                        }
                        else
                        {
                            //建立 MsQnAMaker Client
                            var helper = new isRock.MsQnAMaker.Client(
                            new Uri(Endpoint), QnAKey);
                            var QnAResponse = helper.GetResponse(reply.Trim());
                            var ret = (from c in QnAResponse.answers
                                       orderby c.score descending
                                       select c
                                    ).Take(1);

                            var responseText = UnknowAnswer;
                            if (ret.FirstOrDefault().score > 0)
                                responseText = ret.FirstOrDefault().answer;
                            //回覆
                            this.ReplyMessage(LineEvent.replyToken, responseText);

                            //建立actions，作為ButtonTemplate的用戶回覆行為
                            var actions = new List<isRock.LineBot.TemplateActionBase>();
                            actions.Add(new isRock.LineBot.PostbackActon() { label = "繼續聊天", data = "還想問些什麼呢?" });
                            actions.Add(new isRock.LineBot.PostbackActon() { label = "結束聊天", data = "結束" });


                            var ButtonTemplateMsg = new isRock.LineBot.ButtonsTemplate()
                            {
                                title = "還想問些什麼嗎?",
                                text = "選擇:",
                                altText = "ButtonTemplate",
                                actions = actions
                            };
                            this.PushMessage(LineEvent.source.userId, ButtonTemplateMsg);

                        }
                    }
                    if (LineEvent.message.type == "sticker") //收到貼圖
                        this.ReplyMessage(LineEvent.replyToken, 1, 2);
                }
                if (LineEvent.type == "postback")
                {
                    var data = LineEvent.postback.data;
                    var repmsg = "";

                    if(data == "結束")
                    {
                        //建立actions，作為ButtonTemplate的用戶回覆行為
                        var actions = new List<isRock.LineBot.TemplateActionBase>();
                        actions.Add(new isRock.LineBot.PostbackActon() { label = "有", data = "有幫助" });
                        actions.Add(new isRock.LineBot.PostbackActon() { label = "沒有", data = "沒有幫助" });


                        var ButtonTemplateMsg = new isRock.LineBot.ButtonsTemplate()
                        {
                            title = "感謝您本次的提問!",
                            text = "請問我們的回答對您有幫助嗎?",
                            altText = "結束聊天 ButtonTemplate",
                            actions = actions
                        };
                        this.PushMessage(LineEvent.source.userId, ButtonTemplateMsg);
                    }
                    else if(data == "有幫助")
                    {
                        repmsg = "感謝您本次的提問！您的回饋使我們更加進步。";
                        this.ReplyMessage(LineEvent.replyToken, repmsg);
                    }
                    else if (data == "沒有幫助")
                    {
                        repmsg = "感謝您本次的提問！我們會針對這次的對談進行修正。";
                        this.ReplyMessage(LineEvent.replyToken, repmsg);
                    }
                    else
                    {
                        this.ReplyMessage(LineEvent.replyToken, data);
                    }

                }
                //response OK
                return Ok();
            }
            catch (Exception ex)
            {
                //如果發生錯誤，傳訊息給Admin
                this.PushMessage(AdminUserId, "發生錯誤:\n" + ex.Message);
                //response OK
                return Ok();
            }

        }


    }
}
