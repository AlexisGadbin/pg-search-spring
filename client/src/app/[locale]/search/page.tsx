import { Tabs, TabsContent, TabsList, TabsTrigger } from '@components/ui/tabs'
import SearchContent from '@src/components/search-content.component'
import { type SearchTypes } from '@src/utils/types'
import { useTranslations } from 'next-intl'

const tabs: SearchTypes[] = ['trigram', 'phonetic', 'distance']

const SearchPage = () => {
  const t = useTranslations('search')

  return (
    <section className="flex h-full flex-col items-center justify-center">
      <Tabs defaultValue="trigram" className="w-[400px]">
        <TabsList>
          {tabs.map((tab) => (
            <TabsTrigger key={tab} value={tab}>
              {tab.charAt(0).toUpperCase() + tab.slice(1)}
            </TabsTrigger>
          ))}
        </TabsList>
        {tabs.map((tab) => (
          <TabsContent key={tab} value={tab}>
            <SearchContent
              type={tab}
              placeholder={t('placeholder')}
              label={t('label')}
            />
          </TabsContent>
        ))}
      </Tabs>
    </section>
  )
}
export default SearchPage
